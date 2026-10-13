package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.cumulus.CumulusConfig;
import com.aetherteam.cumulus.api.MenuHelper;
import net.builderdog.ancient_aether.client.gui.AncientAetherMenus;

public class MenuHooks {
    public static void prepareCustomMenus(MenuHelper menuHelper) {
        if (CumulusConfig.CLIENT.active_menu.get().equals("ancient_aether:ancient_aether")) {
            menuHelper.setActiveMenu(AncientAetherMenus.ANCIENT_AETHER);
        }
    }
}
