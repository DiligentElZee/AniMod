package net.mccreators.animod.item;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.entity.ModEntities;
import net.mccreators.animod.item.custom.AnimatedItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AniMod.MOD_ID);

    public static final RegistryObject<Item> PLACEHOLDER = ITEMS.register("placeholder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_PLACEHOLDER = ITEMS.register("small_placeholder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLACEHOLDER_STAFF = ITEMS.register("placeholder_staff",
            () -> new AnimatedItem(new Item.Properties()));

    public static final RegistryObject<Item> WIP_SPAWN_EGG = ITEMS.register("wip_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WIP_ENTITY, 0x00ffcc, 0x00B08D,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
