package curseforge.vampie.recipe;

import curseforge.vampie.TeaTheory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

public final class ModRecipes {
    public static RecipeType<BoilerRecipe> BOILER;

    private ModRecipes() {
    }

    public static void register() {
        BOILER = Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                TeaTheory.id("boiler"),
                new RecipeType<>() {
                    @Override
                    public String toString() {
                        return TeaTheory.MOD_ID + ":boiler";
                    }
                }
        );
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, TeaTheory.id("boiler"), BoilerRecipe.SERIALIZER);
    }
}
