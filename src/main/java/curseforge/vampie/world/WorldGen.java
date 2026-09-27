package curseforge.vampie.world;

import curseforge.vampie.TeaTheory;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WorldGen {
    /** Adds Camellia Sinensis bush generation to forest biomes. */
    public WorldGen() {
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ResourceKey.create(Registries.PLACED_FEATURE, TeaTheory.id("camellia_sinensis_bush"))
        );
    }
}
