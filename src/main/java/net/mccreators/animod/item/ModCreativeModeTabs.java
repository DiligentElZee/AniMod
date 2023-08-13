package net.mccreators.animod.item;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            AniMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> ANIMOD_ALL = CREATIVE_MODE_TABS.register("animod",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLACEHOLDER.get()))
                    .title(Component.translatable("creativemodetab.animod_all")).build());

    public static RegistryObject<CreativeModeTab> ANIMOD_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("animod_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ROTATER.get()))
                    .title(Component.translatable("creativemodetab.animod_building_blocks")).build());

    public static RegistryObject<CreativeModeTab> ANIMOD_ITEMS = CREATIVE_MODE_TABS.register("animod_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLACEHOLDER_STAFF.get()))
                    .title(Component.translatable("creativemodetab.animod_items")).build());

    public static RegistryObject<CreativeModeTab> ANIMOD_COMBAT = CREATIVE_MODE_TABS.register("animod_combat",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMETHYST_CHESPLATE.get()))
                    .title(Component.translatable("creativemodetab.animod_combat")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}