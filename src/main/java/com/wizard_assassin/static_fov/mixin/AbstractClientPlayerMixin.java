package com.wizard_assassin.static_fov.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.entity.AbstractClientPlayer;

@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerMixin {

    @Inject(at = @At("RETURN"), method = "getFovModifier", cancellable = true)
    public void getFovModifier(CallbackInfoReturnable<Float> info) {
        float fovScale = 0.0f;
        float fov = info.getReturnValue();
        info.setReturnValue(1.0f + fovScale * (fov - 1.0f));
    }
}
