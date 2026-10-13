package net.builderdog.ancient_aether.item.equipment.tools.valkyrum;

import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.ValkyrumSwordRange;
import net.minecraft.world.item.SwordItem;

public class ValkyrumSwordItem extends SwordItem implements ValkyrumSwordRange {
    public ValkyrumSwordItem() {
        super(AncientAetherItemTiers.VALKYRUM, new Properties()
            .attributes(ValkyrumSwordRange.extendReachModifier(SwordItem.createAttributes(AncientAetherItemTiers.VALKYRUM, 3, -2.4F))));
    }
}
