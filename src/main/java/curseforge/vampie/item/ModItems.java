package curseforge.vampie.item;

import curseforge.vampie.TeaTheory;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {
    public final Item CAMELLIA_SINENSIS = registerItem("camellia_sinensis", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("camellia_sinensis")
            ))));

    public final Item[] ALL_ITEMS;
    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(TeaTheory.MOD_ID, name), item);
    }
    public ModItems() {
        ALL_ITEMS = new Item[]{CAMELLIA_SINENSIS};
    }
}
