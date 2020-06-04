package com.diraven.tbcrp;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)
public class Main {
    public static final String MODID = "tbcrp";
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
//        LOGGER.debug("Constructor invoked.");
    }
}
