package net.builderdog.ancient_aether.client.gui;

import com.aetherteam.cumulus.api.CumulusEntrypoint;
import com.aetherteam.cumulus.api.Menu;
import com.aetherteam.cumulus.api.MenuInitializer;
import com.aetherteam.cumulus.api.MenuRegisterCallback;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.gui.screen.AncientAetherTitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

@CumulusEntrypoint
public class AncientAetherMenus implements MenuInitializer {
    private static final ResourceLocation ANCIENT_AETHER_ICON = ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "textures/gui/menu_api/menu_icon_ancient_aether.png");
    private static final Component ANCIENT_AETHER_NAME = Component.translatable("ancient_aether.menu_title.ancient_aether");

    public static final Menu ANCIENT_AETHER = new Menu(ANCIENT_AETHER_ICON, ANCIENT_AETHER_NAME, new AncientAetherTitleScreen(true), new Menu.Properties().music(AncientAetherTitleScreen.MENU).panorama(new CubeMap(ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "textures/gui/title/panorama/panorama"))));

    @Override
    public void registerMenus(MenuRegisterCallback menuRegisterCallback) {
        menuRegisterCallback.registerMenu(ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "ancient_aether"), ANCIENT_AETHER);
    }
}
