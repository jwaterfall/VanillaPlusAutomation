package net.vanillaplusautomation.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.block.ModBlocks;

import java.util.Arrays;

public class ModOres {
    public static final ConfiguredFeature<?, ?> BASALT_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "basalt_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.BASALT.getDefaultState(), 64))); // Vein size

    public static final PlacedFeature BASALT_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "basalt_overworld",
            new PlacedFeature(RegistryEntry.of(BASALT_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(4), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
            ))
    );


    public static final ConfiguredFeature<?, ?> MARBLE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "marble_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.MARBLE.getDefaultState(), 64))); // Vein size

    public static final PlacedFeature MARBLE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "marble_overworld",
            new PlacedFeature(RegistryEntry.of(MARBLE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(4), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
            ))
    );


    public static final ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "ruby_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.RUBY_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature RUBY_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "ruby_ore_overworld",
            new PlacedFeature(RegistryEntry.of(RUBY_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))
            ))
    );


    public static final ConfiguredFeature<?, ?> SAPPHIRE_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "sapphire_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SAPPHIRE_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature SAPPHIRE_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "sapphire_ore_overworld",
            new PlacedFeature(RegistryEntry.of(SAPPHIRE_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))
            ))
    );


    public static final ConfiguredFeature<?, ?> PERIDOT_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "peridot_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.PERIDOT_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature PERIDOT_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "peridot_ore_overworld",
            new PlacedFeature(RegistryEntry.of(PERIDOT_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))
            ))
    );


    public static final ConfiguredFeature<?, ?> ELECTROTINE_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "electrotine_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.ELECTROTINE_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature ELECTROTINE_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "electrotine_ore_overworld",
            new PlacedFeature(RegistryEntry.of(ELECTROTINE_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))
            ))
    );


    public static final ConfiguredFeature<?, ?> DEEPSLATE_RUBY_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "deepslate_ruby_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature DEEPSLATE_RUBY_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "deepslate_ruby_ore_overworld",
            new PlacedFeature(RegistryEntry.of(DEEPSLATE_RUBY_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))
            ))
    );


    public static final ConfiguredFeature<?, ?> DEEPSLATE_SAPPHIRE_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "deepslate_sapphire_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature DEEPSLATE_SAPPHIRE_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "deepslate_sapphire_ore_overworld",
            new PlacedFeature(RegistryEntry.of(DEEPSLATE_SAPPHIRE_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))
            ))
    );


    public static final ConfiguredFeature<?, ?> DEEPSLATE_PERIDOT_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "deepslate_peridot_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_PERIDOT_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature DEEPSLATE_PERIDOT_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "deepslate_peridot_ore_overworld",
            new PlacedFeature(RegistryEntry.of(DEEPSLATE_PERIDOT_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))
            ))
    );


    public static final ConfiguredFeature<?, ?> DEEPSLATE_ELECTROTINE_ORE_OVERWORLD_CONFIGURED_FEATURE = registerOreConfiguredFeature(
            "deepslate_electrotine_ore_overworld",
            new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_ELECTROTINE_ORE.getDefaultState(), 9))); // Vein size

    public static final PlacedFeature DEEPSLATE_ELECTROTINE_ORE_OVERWORLD_PLACED_FEATURE = registerOrePlacedFeature(
            "deepslate_electrotine_ore_overworld",
            new PlacedFeature(RegistryEntry.of(DEEPSLATE_ELECTROTINE_ORE_OVERWORLD_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))
            ))
    );


    private static ConfiguredFeature<?, ?> registerOreConfiguredFeature(String name, ConfiguredFeature<?, ?> configuredFeature) {
        RegistryKey<ConfiguredFeature<?, ?>> registryKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(VanillaPlusAutomation.MOD_ID, name));

        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(),
                configuredFeature);
    }


    private static PlacedFeature registerOrePlacedFeature(String name, PlacedFeature placedFeature) {
        RegistryKey<PlacedFeature> registryKey = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(VanillaPlusAutomation.MOD_ID, name));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, registryKey);

        return Registry.register(BuiltinRegistries.PLACED_FEATURE, registryKey.getValue(),
                placedFeature);
    }

    public static void registerModOres() {
        System.out.println("Registering ores for " + VanillaPlusAutomation.MOD_ID);
    }
}
