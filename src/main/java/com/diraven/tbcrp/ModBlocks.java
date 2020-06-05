package com.diraven.tbcrp;

import com.diraven.tbcrp.block.WashingMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> WASHING_MACHINE = BLOCKS.register("washing_machine", () -> new WashingMachine(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)));
}
