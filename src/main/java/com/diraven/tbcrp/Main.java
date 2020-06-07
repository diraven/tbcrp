package com.diraven.tbcrp;

import com.diraven.tbcrp.eternalore.EternalOreBlocks;
import com.diraven.tbcrp.eternalore.EternalOreItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "tbcrp";
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        EternalOreItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EternalOreBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
