package com.diraven.tbcrp.eternalores;

import com.diraven.tbcrp.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EternaloresBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> ETERNAL_COBBLESTONE = BLOCKS.register(
            "eternalores_cobblestone", () -> new EternaloresBlock(
                    Block.Properties.create(Material.ROCK)
                            .hardnessAndResistance(3.0f, 32.0f),
                    5
            )
    );
}
