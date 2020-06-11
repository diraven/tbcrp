package com.diraven.tbcrp.eore;

import com.diraven.tbcrp.Main;
import net.minecraft.block.Block;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


public class EOreData extends WorldSavedData {
    public static final String ID = Main.MOD_ID + "_eternalores";

    public EOreData() {
        super(ID);
    }

    private static class RespawnScheduleRecord {
        EOreBlock what;
        Instant when;

        public RespawnScheduleRecord(EOreBlock what, Instant when) {
            this.what = what;
            this.when = when;
        }
    }

    private final Map<BlockPos, RespawnScheduleRecord> respawnSchedule = new HashMap<>();

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        ListNBT respawnScheduleNBT = new ListNBT();
        respawnSchedule.forEach((blockPos, respawnScheduleRecord) -> {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("x", blockPos.getX());
            compoundNBT.putInt("y", blockPos.getY());
            compoundNBT.putInt("z", blockPos.getZ());
            compoundNBT.putString("what", respawnScheduleRecord.what.getRegistryName().toString());
            compoundNBT.putLong("when", respawnScheduleRecord.when.getEpochSecond());
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
                            (EOreBlock) GameRegistry.findRegistry(Block.class).getValue(
                                    new ResourceLocation(compoundNBT.getString("what"))
                            ),
                            Instant.ofEpochMilli(compoundNBT.getLong("when"))
                    )
            );
        });
    }

    public void scheduleBlockRespawn(BlockPos where, EOreBlock what) {
        respawnSchedule.put(where, new RespawnScheduleRecord(what, Instant.now().plusSeconds(what.cooldownSeconds)));
        markDirty();
    }

    public Map<BlockPos, EOreBlock> getBlocksToRespawn() {
        Map<BlockPos, EOreBlock> blocksToRespawn = new HashMap<>();
        respawnSchedule.entrySet().removeIf(e -> {
            if (e.getValue().when.compareTo(Instant.now()) < 0) {
                blocksToRespawn.put(e.getKey(), e.getValue().what);
                return true;
            }
            return false;
        });
        markDirty();
        return blocksToRespawn;
    }
}
