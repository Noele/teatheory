package curseforge.vampie.block.entity;

import curseforge.vampie.TeaTheory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public final class ModBlockEntities {
    public static BlockEntityType<BoilerBlockEntity> BOILER;

    private ModBlockEntities() {
    }

    /**
     * Registers the boiler block entity type and associates it with its owning block.
     *
     * @param boilerBlock registered boiler block
     */
    public static void register(final Block boilerBlock) {
        BOILER = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                TeaTheory.id("boiler"),
                new BlockEntityType<>(BoilerBlockEntity::new, Set.of(boilerBlock))
        );
    }
}
