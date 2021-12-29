package com.linjey.modpack.tileentity;

import com.linjey.modpack.ModPackMod;
import com.linjey.modpack.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModPackMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightningInfusionerTile>> LIGHTNING_INFUSIONER_TILE =
           TILE_ENTITIES.register("lightning_infusioner_tile", () -> TileEntityType.Builder.create(
                   LightningInfusionerTile::new, ModBlocks.LIGHTNING_INFUSIONER.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }

}
