package com.diraven.tbcrp.eternalores;

import com.diraven.tbcrp.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EternaloresItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> ETERNAL_COBBLESTONE = ITEMS.register(
            "eternal_cobblestone", () -> new BlockItem(
                    EternaloresBlocks.ETERNAL_COBBLESTONE.get(),
                    new Item.Properties()
            )
    );
}
