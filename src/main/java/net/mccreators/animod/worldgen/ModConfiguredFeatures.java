package net.mccreators.animod.worldgen;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WIP_KEY = registerKey("wip");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PLACEHOLDER_ORE_KEY = registerKey("placeholder_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_PLACEHOLDER_ORE_KEY = registerKey("end_placeholder_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PLACEHOLDER_ORE_KEY = registerKey("nether_placeholder_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldPlaceholderOres = List.of(OreConfiguration.target(stoneReplacables,
                ModBlocks.PLACEHOLDER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_PLACEHOLDER_ORE.get().defaultBlockState()));

        register(context, WIP_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WIP_LOG.get()),
                new StraightTrunkPlacer(3, 4, 2),
                BlockStateProvider.simple(ModBlocks.WIP_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 3),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, OVERWORLD_PLACEHOLDER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPlaceholderOres, 9));
        register(context, END_PLACEHOLDER_ORE_KEY, Feature.ORE, new OreConfiguration(endstoneReplacables,
                ModBlocks.ENDSTONE_PLACEHOLDER_ORE.get().defaultBlockState(), 9));
        register(context, NETHER_PLACEHOLDER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHERRACK_PLACEHOLDER_ORE.get().defaultBlockState(), 9));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AniMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
