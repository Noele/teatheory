package curseforge.vampie.item;

import curseforge.vampie.TeaTheory;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item ROLLING_PIN = registerItem("rolling_pin", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("rolling_pin")
            )).stacksTo(1)));


    public static final Item CAMELLIA_SINENSIS = registerItem("camellia_sinensis", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("camellia_sinensis")
            ))));

    public static final Item ROLLED_LEAVES = registerItem("rolled_leaves", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("rolled_leaves")
            ))));

    public static final Item FUKAMUSHICHA_SENCHA_TEA = registerItem("fukamushicha_sencha_tea", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("fukamushicha_sencha_tea")
            )).food(ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_FOODPROPERTIES, ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_CONSUMABLE)));

    public static final Item MATCHA_TEA = registerItem("matcha_tea", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("matcha_tea")
            )).food(ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_FOODPROPERTIES, ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_CONSUMABLE)));

    public static final Item SENCHA_TEA = registerItem("sencha_tea", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("sencha_tea")
            )).food(ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_FOODPROPERTIES, ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_CONSUMABLE)));

    public static final Item HOJICHA_TEA = registerItem("hojicha_tea", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("hojicha_tea")
            )).food(ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_FOODPROPERTIES, ModFoodComponents.FUKAMUSHICHA_SENCHA_TEA_CONSUMABLE)));


    public static final Item FUKAMUSHICHA_SENCHA_TEA_LEAVES = registerItem("fukamushicha_sencha_tea_leaves", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("fukamushicha_sencha_tea_leaves")
            ))));

    public static final Item HOJICHA_TEA_LEAVES = registerItem("hojicha_tea_leaves", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("hojicha_tea_leaves")
            ))));

    public static final Item MATCHA_POWDER = registerItem("matcha_powder", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("matcha_powder")
            ))));

    public static final Item SENCHA_TEA_LEAVES = registerItem("sencha_tea_leaves", new Item(new Item.Properties().setId(
            ResourceKey.create(
                    BuiltInRegistries.ITEM.key(),
                    TeaTheory.id("sencha_tea_leaves")
            ))));

    public final Item[] ALL_ITEMS;

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(TeaTheory.MOD_ID, name), item);
    }

    public ModItems() {
        ALL_ITEMS = new Item[]{ROLLING_PIN, ROLLED_LEAVES, CAMELLIA_SINENSIS, SENCHA_TEA_LEAVES, FUKAMUSHICHA_SENCHA_TEA_LEAVES, HOJICHA_TEA_LEAVES, MATCHA_POWDER, FUKAMUSHICHA_SENCHA_TEA, SENCHA_TEA, MATCHA_TEA, HOJICHA_TEA};
    }
}
