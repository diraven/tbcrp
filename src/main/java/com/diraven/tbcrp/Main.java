package com.diraven.tbcrp;

import com.diraven.tbcrp.eternalores.EternaloresBlocks;
import com.diraven.tbcrp.eternalores.EternaloresItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "tbcrp";
    public static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        EternaloresItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EternaloresBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
