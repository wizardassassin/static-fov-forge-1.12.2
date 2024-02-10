package com.wizard_assassin.static_fov;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = StaticFov.MOD_ID)
public class CustomConfig {
    @RangeDouble(min = 0, max = 1)
    public static float fovScale = 0.0f;
    @RangeDouble(min = 0, max = 1)
    public static float nauseaScale = 0.0f;
    @RangeDouble(min = 0, max = 1)
    public static float tiltScale = 0.0f;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(StaticFov.MOD_ID))
            ConfigManager.sync(StaticFov.MOD_ID, Config.Type.INSTANCE);
    }
}
