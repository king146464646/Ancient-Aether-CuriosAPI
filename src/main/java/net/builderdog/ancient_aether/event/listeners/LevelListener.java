package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.LevelHooks;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;

public class LevelListener {

    public static void listen(IEventBus bus) {
        bus.addListener(LevelListener::onSaplingGrow);
    }

    public static void onSaplingGrow(BlockGrowFeatureEvent event) {
        RandomSource random = event.getRandom();
        Holder<ConfiguredFeature<?, ?>> feature = event.getFeature();
        ResourceKey<ConfiguredFeature<?, ?>> newFeature = LevelHooks.modifyGrownSapling(random, feature);
        if (newFeature != null) {
            event.setFeature(newFeature);
        }
    }
}