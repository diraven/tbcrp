package com.diraven.tbcrp.eternalores;

import javafx.geometry.Pos;
import net.minecraft.block.Block;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EternaloresData extends WorldSavedData {
    public EternaloresData(String name) {
        super("eternalores");
    }

    private static class RespawnScheduleRecord {
        EternaloresBlock what;
        Date when;

        public RespawnScheduleRecord(EternaloresBlock block, Date respawnDatetime) {
            this.what = block;
            this.when = respawnDatetime;
        }
    }

    private Map<BlockPos, RespawnScheduleRecord> respawnSchedule;

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        ListNBT respawnScheduleNBT = new ListNBT();
        respawnSchedule.forEach((blockPos, respawnScheduleRecord) -> {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("x", blockPos.getX());
            compoundNBT.putInt("y", blockPos.getY());
            compoundNBT.putInt("z", blockPos.getZ());
            compoundNBT.putString("what", respawnScheduleRecord.what.getRegistryName().toString());
            compoundNBT.putLong("when", respawnScheduleRecord.when.getTime());
            respawnScheduleNBT.add(compoundNBT);
        });
        nbt.put("respawnSchedule", respawnScheduleNBT);
        return nbt;
    }

    @Override
    public void read(CompoundNBT nbt) {
        ListNBT respawnScheduleNbt = nbt.getList("respawnSchedule", Constants.NBT.TAG_COMPOUND);
        this.respawnSchedule.clear();
        respawnScheduleNbt.forEach(cNBT -> {
            CompoundNBT compoundNBT = (CompoundNBT) cNBT;
            this.respawnSchedule.put(
                    new BlockPos(
                            compoundNBT.getInt("x"),
                            compoundNBT.getInt("y"),
                            compoundNBT.getInt("z")
                    ),
                    new RespawnScheduleRecord(
                            (EternaloresBlock) GameRegistry.findRegistry(Block.class).getValue(
                                    new ResourceLocation(compoundNBT.getString("what"))
                            ),
                            new Date(compoundNBT.getLong("when"))
                    )
            );
        });
    }

    public void scheduleBlockRespawn(BlockPos where, EternaloresBlock what, Date when) {
        respawnSchedule.put(where, new RespawnScheduleRecord(what, when));
        markDirty();
    }

    public Map<BlockPos, EternaloresBlock> getBlocksToRespawn(Dimension dimension, Pos pos, Block block) {
        Map<BlockPos, EternaloresBlock> blocksToRespawn = new HashMap<>();
        respawnSchedule.entrySet().removeIf(e -> {
            if (e.getValue().when.after(new Date())) {
                blocksToRespawn.put(e.getKey(), e.getValue().what);
                return true;
            }
            return false;
        });
        return blocksToRespawn;
    }

    public void delBlocks() {
        markDirty();
    }
}
