package com.example;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> HOLY_HELL = RegistryKey.of(Registry.DIMENSION_KEY, new Identifier(ExampleMod.MOD_ID, "holy_hell"));

    public static void register() {
        // Custom dimensions are normally defined via datapacks (data/<modid>/dimensions/...)
        // This method registers the RegistryKey for use by the mod code (portal teleport logic, etc.).
        // No runtime registration is performed here because Fabric/Minecraft expect dimension JSON files in a datapack.
    }
}