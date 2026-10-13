package net.builderdog.ancient_aether.data.resources.registries.features;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class AncientAetherFeatureUtils {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> configuredFeature) {
        AncientAetherOreFeatures.bootstrap(configuredFeature);
        AncientAetherMiscFeatures.bootstrap(configuredFeature);
        AncientAetherTreeFeatures.bootstrap(configuredFeature);
        AncientAetherVegetationFeatures.bootstrap(configuredFeature);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AncientAether.MODID, name));
    }

    static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, Feature<NoneFeatureConfiguration> feature) {
        register(context, resourceKey, feature, FeatureConfiguration.NONE);
    }
}