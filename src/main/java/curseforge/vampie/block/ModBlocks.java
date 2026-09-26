package curseforge.vampie.block;

import curseforge.vampie.TeaTheory;
import curseforge.vampie.block.custom.BoilerBlock;
import curseforge.vampie.block.custom.CamelliaSinensisBushBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks
{
    public final Block TEA_BRICK = registerBlock("tea_brick",
            new Block(BlockBehaviour.Properties.of().setId(
                    ResourceKey.create(
                            BuiltInRegistries.BLOCK.key(),
                            TeaTheory.id("tea_brick")
                    )
            ).sound(SoundType.GRASS).strength(0.5f)
            ));

    public final Block CAMELLIA_SINENSIS_BUSH = registerBlock("camellia_sinensis_bush",
            new CamelliaSinensisBushBlock(BlockBehaviour.Properties.of().setId(
                    ResourceKey.create(
                            BuiltInRegistries.BLOCK.key(),
                            TeaTheory.id("camellia_sinensis_bush")
                    )
            )
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .noCollision()
                    .noOcclusion()
            ));

    public final Block BOILER_BLOCK = registerBlock("boiler",
            new BoilerBlock(BlockBehaviour.Properties.of().setId(
                    ResourceKey.create(
                            BuiltInRegistries.BLOCK.key(),
                            TeaTheory.id("boiler")
                    )
            )
            ));

    private Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TeaTheory.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(TeaTheory.MOD_ID, name),
                new BlockItem(block, new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), TeaTheory.id(name))))
        );
    }

    public final Item[] ALL_BLOCKS_AS_ITEMS;
    public ModBlocks() {
        ALL_BLOCKS_AS_ITEMS = new Item[] {TEA_BRICK.asItem(), CAMELLIA_SINENSIS_BUSH.asItem(), BOILER_BLOCK.asItem()};
    }
}
