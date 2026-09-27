package curseforge.vampie.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import curseforge.vampie.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.ShapelessCraftingRecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;

import java.util.List;

public class ReusableToolCraftingRecipe implements CraftingRecipe {
    public static final MapCodec<ReusableToolCraftingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder.group(
                    Recipe.CommonInfo.MAP_CODEC.forGetter(recipe -> recipe.commonInfo),
                    CraftingRecipe.CraftingBookInfo.MAP_CODEC.forGetter(recipe -> recipe.bookInfo),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                    Ingredient.CODEC.listOf(1, 9).fieldOf("ingredients").forGetter(recipe -> recipe.ingredients)
            ).apply(builder, ReusableToolCraftingRecipe::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, ReusableToolCraftingRecipe> STREAM_CODEC = StreamCodec.composite(
            Recipe.CommonInfo.STREAM_CODEC,
            recipe -> recipe.commonInfo,
            CraftingRecipe.CraftingBookInfo.STREAM_CODEC,
            recipe -> recipe.bookInfo,
            ItemStackTemplate.STREAM_CODEC,
            recipe -> recipe.result,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()),
            recipe -> recipe.ingredients,
            ReusableToolCraftingRecipe::new
    );
    public static final RecipeSerializer<ReusableToolCraftingRecipe> SERIALIZER =
            new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    private final Recipe.CommonInfo commonInfo;
    private final CraftingRecipe.CraftingBookInfo bookInfo;
    private final ItemStackTemplate result;
    private final List<Ingredient> ingredients;
    private PlacementInfo placementInfo;

    /**
     * Creates a shapeless crafting recipe with the supplied result and ingredients.
     *
     * @param commonInfo shared recipe metadata
     * @param bookInfo crafting-book grouping and category metadata
     * @param result output item stack template
     * @param ingredients ingredients that must be present in the crafting grid
     */
    public ReusableToolCraftingRecipe(
            final Recipe.CommonInfo commonInfo,
            final CraftingRecipe.CraftingBookInfo bookInfo,
            final ItemStackTemplate result,
            final List<Ingredient> ingredients
    ) {
        this.commonInfo = commonInfo;
        this.bookInfo = bookInfo;
        this.result = result;
        this.ingredients = ingredients;
    }

    /** Returns the registered serializer for reusable-tool crafting recipes. */
    @Override
    public RecipeSerializer<ReusableToolCraftingRecipe> getSerializer() {
        return SERIALIZER;
    }

    /** Treats this recipe as a standard crafting-table recipe. */
    @Override
    public RecipeType<CraftingRecipe> getType() {
        return RecipeType.CRAFTING;
    }

    /** Lazily builds the ingredient placement metadata used by the crafting UI. */
    @Override
    public PlacementInfo placementInfo() {
        if (placementInfo == null) {
            placementInfo = PlacementInfo.create(ingredients);
        }
        return placementInfo;
    }

    /** Checks that the crafting grid contains exactly the recipe's ingredients. */
    @Override
    public boolean matches(final CraftingInput input, final Level level) {
        return input.ingredientCount() == ingredients.size()
                && input.stackedContents().canCraft(this, null);
    }

    /** Creates the configured recipe result. */
    @Override
    public ItemStack assemble(final CraftingInput input) {
        return result.create();
    }

    /** Returns the Rolling Pin to its crafting slot instead of consuming it. */
    @Override
    public NonNullList<ItemStack> getRemainingItems(final CraftingInput input) {
        NonNullList<ItemStack> remaining = CraftingRecipe.defaultCraftingReminder(input);
        for (int slot = 0; slot < input.size(); slot++) {
            ItemStack stack = input.getItem(slot);
            if (stack.is(ModItems.ROLLING_PIN)) {
                remaining.set(slot, stack.copyWithCount(1));
            }
        }
        return remaining;
    }

    /** Builds the crafting-book display for this shapeless recipe. */
    @Override
    public List<RecipeDisplay> display() {
        return List.of(new ShapelessCraftingRecipeDisplay(
                ingredients.stream().map(Ingredient::display).toList(),
                new SlotDisplay.ItemStackSlotDisplay(result),
                new SlotDisplay.ItemSlotDisplay(Items.CRAFTING_TABLE)
        ));
    }

    /** Returns the crafting-book group for this recipe. */
    @Override
    public String group() {
        return bookInfo.group();
    }

    /** Returns whether crafting this recipe should show a notification. */
    @Override
    public boolean showNotification() {
        return commonInfo.showNotification();
    }

    /** Returns the crafting-book category configured for this recipe. */
    @Override
    public CraftingBookCategory category() {
        return bookInfo.category();
    }

}
