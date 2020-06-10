package com.diraven.tbcrp.eternalores;

import com.diraven.tbcrp.Main;
import com.sun.media.jfxmedia.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EternaloresEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getState().getBlock() instanceof EternaloresBlock) {
            event.setNewSpeed(event.getOriginalSpeed() * 0.1f);
        }
    }
}
