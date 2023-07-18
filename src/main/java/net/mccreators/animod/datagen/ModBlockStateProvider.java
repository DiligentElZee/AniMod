package net.mccreators.animod.datagen;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AniMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PLACEHOLDER_BLOCK);
        blockWithItem(ModBlocks.NETHERRACK_PLACEHOLDER_ORE);
        blockWithItem(ModBlocks.ENDSTONE_PLACEHOLDER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE);
        blockWithItem(ModBlocks.PLACEHOLDER_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.WIP_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.WIP_WOOD.get(), blockTexture(ModBlocks.WIP_LOG.get()), blockTexture(ModBlocks.WIP_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WIP_LOG.get(), 
                new ResourceLocation(AniMod.MOD_ID, "block/stripped_wip_log"),
                new ResourceLocation(AniMod.MOD_ID, "block/stripped_wip_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WIP_WOOD.get(), 
                new ResourceLocation(AniMod.MOD_ID, "block/stripped_wip_log"),
                new ResourceLocation(AniMod.MOD_ID, "block/stripped_wip_log"));

        blockWithItem(ModBlocks.WIP_PLANKS);
        blockWithItem(ModBlocks.WIP_LEAVES);
        saplingBlock(ModBlocks.WIP_SAPLING);

        simpleBlockItem(ModBlocks.WIP_LOG.get(), models()
                .withExistingParent("animod:wip_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WIP_WOOD.get(), models()
                .withExistingParent("animod:wip_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WIP_LOG.get(), models()
                .withExistingParent("animod:stripped_wip_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WIP_WOOD.get(), models()
                .withExistingParent("animod:stripped_wip_wood", "minecraft:block/cube_column"));
    }

        private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
