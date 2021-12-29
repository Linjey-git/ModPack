package com.linjey.modpack.screen;

import com.linjey.modpack.ModPackMod;
import com.linjey.modpack.container.LightningInfusionerContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class LightningInfusionerScreen extends ContainerScreen<LightningInfusionerContainer> {

    private final ResourceLocation GUI = new ResourceLocation(ModPackMod.MOD_ID,
            "textures/gui/lightning_infusioner_gui.png");

    public LightningInfusionerScreen(LightningInfusionerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int left_pixel = this.guiLeft;
        int top_pixel = this.guiTop;
        this.blit(matrixStack, left_pixel, top_pixel, 0, 0, this.xSize, this.ySize);

        if (container.isLightningStorm()) {
            this.blit(matrixStack, left_pixel + 27, top_pixel + 32,176, 0, 28, 36);
        }

    }
}
