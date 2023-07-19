package net.mccreators.animod.entity;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.entity.custom.WIPEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AniMod.MOD_ID);

    public static final RegistryObject<EntityType<WIPEntity>> WIP_ENTITY =
            ENTITY_TYPES.register("wip",
                    () -> EntityType.Builder.of(WIPEntity::new, MobCategory.CREATURE)
                            .sized(1f, 1f)
                            .build(new ResourceLocation(AniMod.MOD_ID, "wip").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
