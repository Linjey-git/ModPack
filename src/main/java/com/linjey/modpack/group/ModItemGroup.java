package com.linjey.modpack.group;

import com.linjey.modpack.block.ModBlocks;
import com.linjey.modpack.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MODPACK_ITEMS_GROUP = new ItemGroup("modpack_itemsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.REPAIR_SHARD.get());
        }
    };

    public static final ItemGroup MODPACK_TOOLS_GROUP = new ItemGroup("modpack_toolsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.TWILIGHT_CAIN_HANDLE.get());
        }
    };

    public static final ItemGroup MODPACK_BLOCKS_GROUP = new ItemGroup("modpack_blocksTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.LIGHTNING_INFUSIONER.get());
        }
    };

    public static final ItemGroup MODPACK_CRYSTALS_GROUP = new ItemGroup("modpack_crystalsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.FIRE_CRYSTAL.get());
        }
    };

}
