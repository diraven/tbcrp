package com.diraven.tbcrp;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Main.MODID)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        Item item = new Item();
        item.setRegistryName(new ResourceLocation(Main.MODID, "example_item"));
        event.getRegistry().register(item);
        Main.logger.info("test123321");
    }
}
