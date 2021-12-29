package com.linjey.modpack.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.linjey.modpack.block.ModBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Objects;

public class LightningInfusionerRecipe implements ILightningInfusionerRecipe {

    public enum Weather {
        CLEAR,
        RAIN,
        THUNDERING;

        public static Weather getWeatherByString(String weather) {
            return Objects.equals(weather, "thundering") ? THUNDERING
                    : Objects.equals(weather, "rain") ? RAIN
                    : CLEAR;
        }
    }

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final Weather weather;

    public LightningInfusionerRecipe(ResourceLocation id, ItemStack output,
                                     NonNullList<Ingredient> recipeItems, Weather weather) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.weather = weather;
    }


    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if (recipeItems.get(0).test(inv.getStackInSlot(0)) &&
                recipeItems.get(1).test(inv.getStackInSlot(1))) {
            return recipeItems.get(2).test(inv.getStackInSlot(2));
        }

        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    public Weather getWeather() {
        return this.weather;
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.LIGHTNING_INFUSIONER.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.LIGHTNING_INFUSION_SERIALIZER.get();
    }

    public static class LightningInfusionerRecipeType implements IRecipeType<LightningInfusionerRecipe> {
        @Override
        public String toString() {
            return LightningInfusionerRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
        implements IRecipeSerializer<LightningInfusionerRecipe> {

        @Override
        public LightningInfusionerRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));
            String weather = JSONUtils.getString(json, "weather");

            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.deserialize(ingredients.get(i)));
            }

            return new LightningInfusionerRecipe(recipeId, output,
                    inputs, Weather.getWeatherByString(weather));
        }

        @Nullable
        @Override
        public LightningInfusionerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.read(buffer));
            }

            ItemStack output = buffer.readItemStack();
            return new LightningInfusionerRecipe(recipeId, output,
                    inputs, null);
        }

        @Override
        public void write(PacketBuffer buffer, LightningInfusionerRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
    }

}
