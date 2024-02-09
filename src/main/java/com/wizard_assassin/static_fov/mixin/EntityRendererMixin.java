package com.wizard_assassin.static_fov.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.EntityRenderer;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Final
    @Shadow
    private Minecraft mc;

    @Redirect(method = "getFOVModifier", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/state/IBlockState;getMaterial()Lnet/minecraft/block/material/Material;"))
    private Material redirectGetMaterial(IBlockState iblockstate) {
        return null;
    }

    @Inject(method = "getFOVModifier", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void getFOVModifier(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable<Float> info,
            Entity entity, float f, IBlockState iblockstate) {
        if (iblockstate.getMaterial() != Material.WATER || iblockstate.getMaterial() != Material.LAVA)
            return;
        float fovScale = 0.0f;
        float fov = info.getReturnValue();
        info.setReturnValue(fov * (1.0f + fovScale * ((60.0F / 70.0F) - 1.0f)));
    }

    @ModifyVariable(method = "setupCameraTransform", at = @At("STORE"), ordinal = 2)
    private float modifyF1(float f1) {
        float nauseaScale = 0.0f;
        return f1 * (nauseaScale * nauseaScale);
    }
}
