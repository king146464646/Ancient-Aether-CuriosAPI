package net.builderdog.ancient_aether.item.equipment;

import com.aetherteam.aether.client.AetherSoundEvents;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class AncientAetherArmorTiers {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, AncientAether.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VALKYRUM = ARMOR_MATERIALS.register("valkyrum", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 10, AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, (Supplier<Ingredient>) () -> Ingredient.of(AncientAetherTags.Items.VALKYRUM_REPAIRING), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, "valkyrum"))), 2.0F, 0.0F));

    public static final int VALKYRUM_DURABILITY_FACTOR = 33;

    public static int durabilityFor(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> 13 * VALKYRUM_DURABILITY_FACTOR;
            case LEGGINGS -> 15 * VALKYRUM_DURABILITY_FACTOR;
            case CHESTPLATE -> 16 * VALKYRUM_DURABILITY_FACTOR;
            case HELMET -> 11 * VALKYRUM_DURABILITY_FACTOR;
            case BODY -> 0;
        };
    }
}
