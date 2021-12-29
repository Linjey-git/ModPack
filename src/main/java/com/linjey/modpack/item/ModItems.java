package com.linjey.modpack.item;

import com.linjey.modpack.ModPackMod;
import com.linjey.modpack.enums.TwilightMaterial;
import com.linjey.modpack.group.ModItemGroup;
import com.linjey.modpack.item.custom.OrbOfTemporaryFlightItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModPackMod.MOD_ID);

    public static final RegistryObject<Item> FIRE_CRYSTAL = ITEMS.register("fire_crystal",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_CRYSTALS_GROUP)));

    public static final RegistryObject<Item> WATER_CRYSTAL = ITEMS.register("water_crystal",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_CRYSTALS_GROUP)));

    public static final RegistryObject<Item> WIND_CRYSTAL = ITEMS.register("wind_crystal",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_CRYSTALS_GROUP)));

    public static final RegistryObject<Item> EARTH_CRYSTAL = ITEMS.register("earth_crystal",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_CRYSTALS_GROUP)));

    public static final RegistryObject<Item> DRAGON_BLACK_SCALE_PIECE = ITEMS.register("dragon_black_scale_piece",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> REPAIR_SHARD = ITEMS.register("repair_shard",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> WITHER_EYE_PART_ONE = ITEMS.register("wither_eye_part_one",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> WITHER_EYE_PART_TWO = ITEMS.register("wither_eye_part_two",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> MAGICAL_EYE_PART_ONE = ITEMS.register("magical_eye_part_one",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> MAGICAL_EYE_PART_TWO = ITEMS.register("magical_eye_part_two",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> GUARDIAN_EYE_PART_ONE = ITEMS.register("guardian_eye_part_one",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> GUARDIAN_EYE_PART_TWO = ITEMS.register("guardian_eye_part_two",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP)));

    public static final RegistryObject<Item> TWILIGHT_CAIN_BLADE = ITEMS.register("twilight_cain_blade",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_TOOLS_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> TWILIGHT_CAIN_HANDLE = ITEMS.register("twilight_cain_handle",
            () -> new Item(new Item.Properties().group(ModItemGroup.MODPACK_TOOLS_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> ORB_OF_TEMPORARY_FLIGHT = ITEMS.register("orb_of_temporary_flight",
            () -> new OrbOfTemporaryFlightItem(new Item.Properties().group(ModItemGroup.MODPACK_ITEMS_GROUP).maxStackSize(1)));

    public static final RegistryObject<SwordItem> TWILIGHT_CAIN = ITEMS.register("twilight_cain",
            () -> new SwordItem(TwilightMaterial.TWILIGHT_MATERIAL, 4, -2,
                    new Item.Properties().group(ModItemGroup.MODPACK_TOOLS_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
