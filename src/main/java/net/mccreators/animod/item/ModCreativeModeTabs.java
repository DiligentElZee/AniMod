package net.mccreators.animod.item;

import net.mccreators.animod.AniMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AniMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab ANIMOD_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ANIMOD_TAB = event.registerCreativeModeTab(new ResourceLocation(AniMod.MOD_ID, "animod_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SMALL_PLACEHOLDER.get()))
                        .title(Component.translatable("creativemodetab.animod_tab")));
    }
}

