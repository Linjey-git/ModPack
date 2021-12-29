package com.linjey.modpack.item.custom;

import com.linjey.modpack.effect.ModEffects;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class OrbOfTemporaryFlightItem extends Item {

    public OrbOfTemporaryFlightItem(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, PlayerEntity player, @Nonnull Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        stack.shrink(1);
        player.addStat(Stats.ITEM_USED.get(this));
        player.addPotionEffect(new EffectInstance(ModEffects.FLY.get(), 2400));
        return ActionResult.func_233538_a_(stack, world.isRemote());
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.modpack.orb_of_temporary_flight_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.modpack.orb_of_temporary_flight"));
        }


        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
