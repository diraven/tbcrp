package com.diraven.tbcrp;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WASHING_MACHINE = ITEMS.register("washing_machine", () -> new BlockItem(ModBlocks.WASHING_MACHINE.get(), new Item.Properties()));
}
