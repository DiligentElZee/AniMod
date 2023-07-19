package net.mccreators.animod.event;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.entity.ModEntities;
import net.mccreators.animod.entity.custom.WIPEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AniMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.WIP_ENTITY.get(), WIPEntity.setAttributes());
    }
}
