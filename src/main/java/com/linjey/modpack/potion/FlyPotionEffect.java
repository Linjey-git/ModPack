package com.linjey.modpack.potion;

import com.linjey.modpack.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class FlyPotionEffect extends Effect {

    public FlyPotionEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        int i = entityLivingBaseIn.getActivePotionEffect(ModEffects.FLY.get()).getDuration();
        if (entityLivingBaseIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLivingBaseIn;
            if (i <= 30 && !player.abilities.isCreativeMode) {
                player.abilities.allowFlying = false;
                player.abilities.isFlying = false;
            } else {
                player.abilities.allowFlying = true;
            }
        }
    }

}
