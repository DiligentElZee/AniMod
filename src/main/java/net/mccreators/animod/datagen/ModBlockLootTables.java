package net.mccreators.animod.datagen;

import net.mccreators.animod.block.ModBlocks;
import net.mccreators.animod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PLACEHOLDER_BLOCK.get());

        add(ModBlocks.PLACEHOLDER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.PLACEHOLDER_ORE.get(), ModItems.SMALL_PLACEHOLDER.get()));
        add(ModBlocks.ENDSTONE_PLACEHOLDER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_PLACEHOLDER_ORE.get(), ModItems.SMALL_PLACEHOLDER.get()));
        add(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE.get(), ModItems.SMALL_PLACEHOLDER.get()));
        add(ModBlocks.NETHERRACK_PLACEHOLDER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_PLACEHOLDER_ORE.get(), ModItems.SMALL_PLACEHOLDER.get()));

        this.dropSelf(ModBlocks.ROTATER.get());

        this.dropSelf(ModBlocks.STRIPPED_WIP_LOG.get());
        this.dropSelf(ModBlocks.WIP_LOG.get());
        this.dropSelf(ModBlocks.WIP_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_WIP_WOOD.get());
        this.dropSelf(ModBlocks.WIP_WOOD.get());
        this.dropSelf(ModBlocks.WIP_SAPLING.get());

        this.add(ModBlocks.WIP_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.WIP_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
