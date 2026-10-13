package net.builderdog.ancient_aether.client.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.fml.VersionChecker;
import net.neoforged.fml.i18n.FMLTranslations;
import net.neoforged.fml.loading.FMLConfig;
import net.neoforged.neoforge.client.loading.ClientModLoader;
import net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class AncientAetherModUpdateIndicator implements Renderable {
    private static final ResourceLocation VERSION_CHECK_ICONS = ResourceLocation.fromNamespaceAndPath(NeoForgeVersion.MOD_ID, "textures/gui/version_check_icons.png");
    private final AncientAetherTitleScreen screen;
    private int width;
    private int height;
    private Font font;
    @Nullable
    private VersionChecker.Status showNotification = null;
    private boolean hasCheckedForUpdates = false;

    public AncientAetherModUpdateIndicator(AncientAetherTitleScreen screen) {
        this.screen = screen;
    }

    public void init() {
        if (!hasCheckedForUpdates) {
            showNotification = ClientModLoader.checkForUpdates();
            hasCheckedForUpdates = true;
        }
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        if (showNotification != null && showNotification.shouldDraw() && !FMLConfig.getBoolConfigValue(FMLConfig.ConfigValue.VERSION_CHECK) && Minecraft.getInstance().screen != null) {
            width = Minecraft.getInstance().screen.width;
            height = Minecraft.getInstance().screen.height;
            font = Minecraft.getInstance().font;
            int modCount = ModList.get().size();
            String modText = FMLTranslations.parseMessage("fml.menu.loadingmods", modCount);

            int x = width - font.width(modText) - 11;
            int y = height - font.lineHeight - 11;

            if (!screen.isAlignedLeft()) {
                x = font.width(modText) + 4;
                y = height - font.lineHeight - 1;
            }
            graphics.blit(VERSION_CHECK_ICONS, x, y, showNotification.getSheetOffset() * 8, (showNotification.isAnimated() && ((System.currentTimeMillis() / 800 & 1) == 1)) ? 8 : 0, 8, 8, 64, 16);
        }
    }
}
