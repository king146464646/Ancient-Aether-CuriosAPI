package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.data.generators.loot.AncientAetherBlockLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientAetherChestLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientAetherEntityLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientAetherSelectorLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AncientAetherLootTableData {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(AncientAetherBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(AncientAetherEntityLoot::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(provider -> new AncientAetherChestLoot(), LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(provider -> new AncientAetherSelectorLoot(), LootContextParamSets.SELECTOR)
        ), registries);
    }
}
