package com.wizard_assassin.staticfov;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StaticFov.MOD_ID)
public class StaticFov {
    public static final String MOD_ID = "staticfov";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Hello world!");
    }
}
