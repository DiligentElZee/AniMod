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

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
