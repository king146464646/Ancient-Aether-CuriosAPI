package net.builderdog.ancient_aether.effect;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, AncientAether.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> DIVINE_PROTECTION = EFFECTS.register("divine_protection", () -> new DivineProtectionEffect().addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "divine_protection"), 3, AttributeModifier.Operation.ADD_VALUE));
    public static final DeferredHolder<MobEffect, MobEffect> NATURES_BOOST = EFFECTS.register("natures_boost", NaturesBoostEffect::new);
}