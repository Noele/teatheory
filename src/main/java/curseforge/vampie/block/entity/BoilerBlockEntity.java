package curseforge.vampie.block.entity;

import curseforge.vampie.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BoilerBlockEntity extends AbstractFurnaceBlockEntity {
    private static final Component DEFAULT_NAME = Component.translatable("container.teatheory.boiler");

    public BoilerBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(ModBlockEntities.BOILER, worldPosition, blockState, ModRecipes.BOILER);
    }

    /** Supplies the localized default title shown for the boiler menu. */
    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    /** Uses the furnace menu to expose the boiler's input, fuel, and output slots. */
    @Override
    protected AbstractContainerMenu createMenu(final int containerId, final Inventory inventory) {
        return new FurnaceMenu(containerId, inventory, this, this.dataAccess);
    }
}
