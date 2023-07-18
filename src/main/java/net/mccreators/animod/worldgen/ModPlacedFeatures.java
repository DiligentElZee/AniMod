package net.mccreators.animod.worldgen;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WIP_PLACED_KEY = createKey("wip_placed");

    public static final ResourceKey<PlacedFeature> PLACEHOLDER_PLACED_KEY = createKey("placeholder_placed");
    public static final ResourceKey<PlacedFeature> END_PLACEHOLDER_PLACED_KEY = createKey("end_placeholder_placed");
    public static final ResourceKey<PlacedFeature> NETHER_PLACEHOLDER_PLACED_KEY = createKey("nether_placeholder_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WIP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WIP_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.2f, 1), ModBlocks.WIP_SAPLING.get()));

        register(context, PLACEHOLDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PLACEHOLDER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, END_PLACEHOLDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PLACEHOLDER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, NETHER_PLACEHOLDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_PLACEHOLDER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AniMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}