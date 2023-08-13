package net.mccreators.animod;

import com.mojang.logging.LogUtils;
import net.mccreators.animod.block.ModBlocks;
import net.mccreators.animod.block.entity.ModBlockEntities;
import net.mccreators.animod.block.entity.client.AnimatedBlockRenderer;
import net.mccreators.animod.entity.ModEntities;
import net.mccreators.animod.entity.client.WIPRenderer;
import net.mccreators.animod.item.ModCreativeModeTabs;
import net.mccreators.animod.item.ModItems;
import net.mccreators.animod.sound.ModSounds;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AniMod.MOD_ID)
public class AniMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "animod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AniMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        GeckoLib.initialize();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            event.accept(ModItems.PLACEHOLDER);
            event.accept(ModItems.SMALL_PLACEHOLDER);

            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModItems.PLACEHOLDER_STAFF);
            event.accept(ModItems.AMETHYST_HELMET);
            event.accept(ModItems.AMETHYST_CHESPLATE);
            event.accept(ModItems.AMETHYST_LEGGINGS);
            event.accept(ModItems.AMETHYST_BOOTS);

            event.accept(ModItems.ROTATER_ITEM);

            event.accept(ModBlocks.PLACEHOLDER_ORE);
            event.accept(ModBlocks.ENDSTONE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.NETHERRACK_PLACEHOLDER_ORE);

            event.accept(ModBlocks.WIP_SAPLING);
            event.accept(ModBlocks.WIP_LOG);
            event.accept(ModBlocks.STRIPPED_WIP_LOG);
            event.accept(ModBlocks.WIP_WOOD);
            event.accept(ModBlocks.STRIPPED_WIP_WOOD);
            event.accept(ModBlocks.WIP_LEAVES);
            event.accept(ModBlocks.WIP_PLANKS);

            event.accept(ModItems.TEST_GIORNO_GIOVANNA_MUSIC_DISC);
        }

        if (event.getTab() == ModCreativeModeTabs.ANIMOD_ALL.get()) {
            event.accept(ModItems.PLACEHOLDER);
            event.accept(ModItems.SMALL_PLACEHOLDER);

            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModItems.PLACEHOLDER_STAFF);

            event.accept(ModItems.AMETHYST_HELMET);
            event.accept(ModItems.AMETHYST_CHESPLATE);
            event.accept(ModItems.AMETHYST_LEGGINGS);
            event.accept(ModItems.AMETHYST_BOOTS);

            event.accept(ModBlocks.ROTATER);

            event.accept(ModBlocks.PLACEHOLDER_ORE);
            event.accept(ModBlocks.ENDSTONE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.NETHERRACK_PLACEHOLDER_ORE);

            event.accept(ModItems.WIP_SPAWN_EGG);

            event.accept(ModBlocks.WIP_SAPLING);
            event.accept(ModBlocks.WIP_LOG);
            event.accept(ModBlocks.STRIPPED_WIP_LOG);
            event.accept(ModBlocks.WIP_WOOD);
            event.accept(ModBlocks.STRIPPED_WIP_WOOD);
            event.accept(ModBlocks.WIP_LEAVES);
            event.accept(ModBlocks.WIP_PLANKS);
        }
        if (event.getTab() == ModCreativeModeTabs.ANIMOD_BUILDING_BLOCKS.get()) {
            event.accept(ModBlocks.PLACEHOLDER_BLOCK);
            event.accept(ModBlocks.ROTATER);
            event.accept(ModBlocks.WIP_WOOD);
            event.accept(ModBlocks.STRIPPED_WIP_WOOD);
            event.accept(ModBlocks.STRIPPED_WIP_LOG);
            event.accept(ModBlocks.WIP_PLANKS);
        }
        if (event.getTab() == ModCreativeModeTabs.ANIMOD_ITEMS.get()) {
            event.accept(ModItems.PLACEHOLDER);
            event.accept(ModItems.SMALL_PLACEHOLDER);
            event.accept(ModItems.PLACEHOLDER_STAFF);
        }
        if (event.getTab() == ModCreativeModeTabs.ANIMOD_COMBAT.get()) {
            event.accept(ModItems.AMETHYST_HELMET);
            event.accept(ModItems.AMETHYST_CHESPLATE);
            event.accept(ModItems.AMETHYST_LEGGINGS);
            event.accept(ModItems.AMETHYST_BOOTS);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.PLACEHOLDER_ORE);
            event.accept(ModBlocks.ENDSTONE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.DEEPSLATE_PLACEHOLDER_ORE);
            event.accept(ModBlocks.NETHERRACK_PLACEHOLDER_ORE);

            event.accept(ModBlocks.WIP_SAPLING);
            event.accept(ModBlocks.WIP_LOG);
            event.accept(ModBlocks.STRIPPED_WIP_LOG);
            event.accept(ModBlocks.WIP_WOOD);
            event.accept(ModBlocks.STRIPPED_WIP_WOOD);
            event.accept(ModBlocks.WIP_LEAVES);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModBlocks.WIP_PLANKS);
        }

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.WIP_SPAWN_EGG);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.TEST_GIORNO_GIOVANNA_MUSIC_DISC);
            event.accept(ModItems.PLACEHOLDER_STAFF);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.AMETHYST_HELMET);
            event.accept(ModItems.AMETHYST_CHESPLATE);
            event.accept(ModItems.AMETHYST_LEGGINGS);
            event.accept(ModItems.AMETHYST_BOOTS);        }
    }
        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                EntityRenderers.register(ModEntities.WIP_ENTITY.get(), WIPRenderer::new);
                BlockEntityRenderers.register(ModBlockEntities.ANIMATED_BLOCK_ENTITY.get(), AnimatedBlockRenderer::new);
            }
    }
}
