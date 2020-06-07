package com.diraven.tbcrp.eternalore;

import com.diraven.tbcrp.Main;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EternalOreEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getState().getBlock() instanceof EternalOreBlock) {
            event.setNewSpeed(event.getOriginalSpeed() * 0.1f);
        }
    }
}
