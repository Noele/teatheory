package curseforge.vampie.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStackTemplate;

public class BoilerRecipe extends AbstractCookingRecipe {
    public static final MapCodec<BoilerRecipe> MAP_CODEC = AbstractCookingRecipe.cookingMapCodec(BoilerRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, BoilerRecipe> STREAM_CODEC =
            AbstractCookingRecipe.cookingStreamCodec(BoilerRecipe::new);
    public static final RecipeSerializer<BoilerRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    /**
     * Creates a cooking recipe processed by the Boiler.
     *
     * @param commonInfo shared recipe metadata
     * @param bookInfo cooking recipe-book metadata
     * @param ingredient input ingredient
     * @param result output item stack template
     * @param experience experience awarded when processing completes
     * @param cookingTime processing duration in ticks
     */
    public BoilerRecipe(
            final Recipe.CommonInfo commonInfo,
            final CookingBookInfo bookInfo,
            final Ingredient ingredient,
            final ItemStackTemplate result,
            final float experience,
            final int cookingTime
    ) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    /** Uses the furnace icon for the boiler recipe-book category. */
    @Override
    protected Item furnaceIcon() {
        return Items.FURNACE;
    }

    /** Identifies recipes processed by the custom Boiler block. */
    @Override
    public RecipeType<BoilerRecipe> getType() {
        return ModRecipes.BOILER;
    }

    /** Returns the serializer used to load and synchronize boiler recipes. */
    @Override
    public RecipeSerializer<BoilerRecipe> getSerializer() {
        return SERIALIZER;
    }

    /** Places boiler recipes in the miscellaneous furnace recipe-book category. */
    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }
}
