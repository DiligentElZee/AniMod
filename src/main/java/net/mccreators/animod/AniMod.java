package net.mccreators.animod;

import com.mojang.logging.LogUtils;
import net.mccreators.animod.block.ModBlocks;
import net.mccreators.animod.entity.ModEntities;
import net.mccreators.animod.entity.client.WIPRenderer;
import net.mccreators.animod.item.ModCreativeModeTabs;
import net.mccreators.animod.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AniMod.MOD_ID)
public class AniMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "animod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AniMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SEARCH) {
            event.accept(ModItems.PLACEHOLDER);
            event.accept(ModItems.SMALL_PLACEHOLDER);

            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModItems.PLACEHOLDER_STAFF);

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
        }

        if (event.getTab() == ModCreativeModeTabs.ANIMOD_TAB) {
            event.accept(ModItems.PLACEHOLDER);
            event.accept(ModItems.SMALL_PLACEHOLDER);

            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModItems.PLACEHOLDER_STAFF);

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

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
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

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PLACEHOLDER_BLOCK);

            event.accept(ModBlocks.WIP_PLANKS);
        }

        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.WIP_SPAWN_EGG);
        }

        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.PLACEHOLDER_STAFF);
        }
    }
        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                EntityRenderers.register(ModEntities.WIP_ENTITY.get(), WIPRenderer::new);
            }
    }
}
