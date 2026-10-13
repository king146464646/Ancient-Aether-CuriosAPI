package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherBlockLootSubProvider;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.loot.functions.DoubleDrops;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

public abstract class AncientAetherBlockLootSubProvider extends AetherBlockLootSubProvider {
    public AncientAetherBlockLootSubProvider(Set<Item> items, FeatureFlagSet flags, HolderLookup.Provider registries) {
        super(items, flags, registries);
    }

    protected void dropCampfire(Block block, ItemLike itemLike) {
        add(block, createSilkTouchDispatchTable(block, applyExplosionDecay(itemLike, LootItem.lootTableItem(itemLike).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))))));
    }

    protected void dropClay(Block block, ItemLike itemLike) {
        add(block, createSilkTouchDispatchTable(block, applyExplosionDecay(itemLike, LootItem.lootTableItem(itemLike).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4))).apply(DoubleDrops.builder()))));
    }

    public LootTable.Builder droppingCrystalSkyrootLeaves(Block block, Block sapling, float... chances) {
        return droppingWithChancesAndSkyrootSticks(block, sapling, chances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_SHEARS.or(this.hasSilkTouch()).invert())
                        .add(applyExplosionCondition(block,
                                LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.holderOrThrow(Enchantments.FORTUNE), 0.0055F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }
}