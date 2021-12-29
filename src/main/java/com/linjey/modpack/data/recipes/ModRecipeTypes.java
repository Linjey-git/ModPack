package com.linjey.modpack.data.recipes;

import com.linjey.modpack.ModPackMod;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModPackMod.MOD_ID);

    public static final RegistryObject<LightningInfusionerRecipe.Serializer> LIGHTNING_INFUSION_SERIALIZER =
            RECIPE_SERIALIZER.register("lightning_infusion", LightningInfusionerRecipe.Serializer::new);
    public static IRecipeType<LightningInfusionerRecipe> LIGHTNING_INFUSION_RECIPE =
            new LightningInfusionerRecipe.LightningInfusionerRecipeType();

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, LightningInfusionerRecipe.TYPE_ID, LIGHTNING_INFUSION_RECIPE);
    }
}
