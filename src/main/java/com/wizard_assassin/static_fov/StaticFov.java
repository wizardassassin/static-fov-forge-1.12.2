package com.wizard_assassin.static_fov;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StaticFov.MOD_ID)
public class StaticFov {
    public static final String MOD_ID = "static-fov";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Hello world!");
    }
}
