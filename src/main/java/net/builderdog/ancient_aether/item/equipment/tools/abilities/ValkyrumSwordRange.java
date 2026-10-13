package net.builderdog.ancient_aether.item.equipment.tools.abilities;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public interface ValkyrumSwordRange {
    ResourceLocation REACH_DISTANCE_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "valkyrum_reach_distance");
    ResourceLocation ATTACK_RANGE_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "valkyrum_attack_range");

    static ItemAttributeModifiers extendReachModifier(ItemAttributeModifiers modifiers) {
        return modifiers
            .withModifierAdded(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(REACH_DISTANCE_MODIFIER_ID, getModifier(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(ATTACK_RANGE_MODIFIER_ID, getModifier(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
    }

    private static double getModifier() {
        return 1;
    }
}
