package com.linjey.modpack.data.recipes;

import com.linjey.modpack.ModPackMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface ILightningInfusionerRecipe extends IRecipe<IInventory> {

    ResourceLocation TYPE_ID = new ResourceLocation(ModPackMod.MOD_ID, "lightning_infusion");


    @Override
    default IRecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return true;
    }

    @Override
    default boolean isDynamic() {
        return true;
    }


}
