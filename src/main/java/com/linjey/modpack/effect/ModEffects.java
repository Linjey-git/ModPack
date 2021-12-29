package com.linjey.modpack.effect;

import com.linjey.modpack.ModPackMod;
import com.linjey.modpack.potion.FlyPotionEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, ModPackMod.MOD_ID);

    public static final RegistryObject<Effect> FLY = register("fly", new FlyPotionEffect(EffectType.BENEFICIAL, 745784));

    private static <T extends Effect> RegistryObject<T> register(String name, T effect) {
        return EFFECTS.register(name, () -> effect);
    }

}
