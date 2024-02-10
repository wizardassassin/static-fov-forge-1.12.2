package com.wizard_assassin.static_fov;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StaticFov.MOD_ID, clientSideOnly = true)
public class StaticFov {
    public static final String MOD_ID = "static-fov";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(CustomConfig.class);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
