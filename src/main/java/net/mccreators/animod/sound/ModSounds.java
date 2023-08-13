package net.mccreators.animod.sound;

import net.mccreators.animod.AniMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AniMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ROTATE_SOUND = registerSoundEvent("rotating_sound");

    public static final RegistryObject<SoundEvent> ROTATING_BLOCK_BREAK = registerSoundEvent("rotating_block_break");
    public static final RegistryObject<SoundEvent> ROTATING_BLOCK_HIT = registerSoundEvent("rotating_block_hit");
    public static final RegistryObject<SoundEvent> ROTATING_BLOCK_PLACE = registerSoundEvent("rotating_block_place");
    public static final RegistryObject<SoundEvent> ROTATING_BLOCK_WALK = registerSoundEvent("rotating_block_walk");

    public static final RegistryObject<SoundEvent> TEST_GIORNO_GIOVANNA = registerSoundEvent("test_giorno_giovanna");

    public static final ForgeSoundType ROTATING_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.ROTATING_BLOCK_BREAK, ModSounds.ROTATING_BLOCK_WALK, ModSounds.ROTATING_BLOCK_PLACE, ModSounds.ROTATING_BLOCK_HIT,
            ModSounds.ROTATING_BLOCK_WALK);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        ResourceLocation id = new ResourceLocation(AniMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
