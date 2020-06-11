package com.diraven.tbcrp.eore;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EOreEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getState().getBlock() instanceof EOreBlock) {
            event.setNewSpeed(event.getOriginalSpeed() * Main.MINING_SPEED_MULTIPLIER);
        }
    }

    @SubscribeEvent
    public static void onWorldTickEvent(TickEvent.WorldTickEvent event) {
        if (event.side.isServer() && event.world.getDayTime() % Main.ORE_SPAWN_PERIOD_TICKS == 0) {
            EOreData eOresData = ((ServerWorld) event.world.getWorld()).getSavedData().getOrCreate(EOreData::new, EOreData.ID);
            Map<BlockPos, EOreBlock> blocksToRespawn = eOresData.getBlocksToRespawn();
            blocksToRespawn.forEach((where, what) -> {
                event.world.setBlockState(where, what.getDefaultState(), 1 | 2);
            });
        }
    }
}
