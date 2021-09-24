package net.vanillaplusautomation.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.GenerationStep;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.block.ModBlocks;

public class ModOres {
        public static final ConfiguredFeature<?, ?> BASALT_OVERWORLD = registerOreOverworld("basalt_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.BASALT.getDefaultState(), 32)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(64))))
                                        .spreadHorizontally().repeat(5));

        public static final ConfiguredFeature<?, ?> MARBLE_OVERWORLD = registerOreOverworld("marble_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.MARBLE.getDefaultState(), 32)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(64))))
                                        .spreadHorizontally().repeat(5));

        public static final ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD = registerOreOverworld("ruby_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.RUBY_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> SAPPHIRE_ORE_OVERWORLD = registerOreOverworld(
                        "sapphire_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.SAPPHIRE_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> PERIDOT_ORE_OVERWORLD = registerOreOverworld(
                        "peridot_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.PERIDOT_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> ELECTROTINE_ORE_OVERWORLD = registerOreOverworld(
                        "electrotine_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                                        ModBlocks.ELECTROTINE_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(20));

        public static final ConfiguredFeature<?, ?> DEEPSLATE_RUBY_ORE_OVERWORLD = registerOreOverworld(
                        "deepslate_ruby_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> DEEPSLATE_SAPPHIRE_ORE_OVERWORLD = registerOreOverworld(
                        "deepslate_sapphire_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> DEEPSLATE_PERIDOT_ORE_OVERWORLD = registerOreOverworld(
                        "deepslate_peridot_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_PERIDOT_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(10));

        public static final ConfiguredFeature<?, ?> DEEPSLATE_ELECTROTINE_ORE_OVERWORLD = registerOreOverworld(
                        "deepslate_electrotine_ore_overworld",
                        Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_ELECTROTINE_ORE.getDefaultState(), 9)) // Vein size
                                        .range(new RangeDecoratorConfig(UniformHeightProvider
                                                        .create(YOffset.aboveBottom(0), YOffset.fixed(32))))
                                        .spreadHorizontally().repeat(20));

        private static ConfiguredFeature<?, ?> registerOreOverworld(String name,
                        ConfiguredFeature<?, ?> configuredFeature) {
                RegistryKey<ConfiguredFeature<?, ?>> registryKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                                new Identifier(VanillaPlusAutomation.MOD_ID, name));
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                GenerationStep.Feature.UNDERGROUND_ORES, registryKey);
                return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(),
                                configuredFeature);
        }

        public static void registerModOres() {
                System.out.println("Registering ores for " + VanillaPlusAutomation.MOD_ID);
        }
}
