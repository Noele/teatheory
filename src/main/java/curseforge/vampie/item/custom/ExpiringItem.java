package curseforge.vampie.item.custom;

import curseforge.vampie.item.ModDataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ExpiringItem extends Item {
    private Item replacement;
    private int lifetimeTicks;

    public ExpiringItem(final Properties properties) {
        super(properties);
    }

    /**
     * Configures this item to transform into another item after its inventory lifetime.
     *
     * @param replacement item to become when the lifetime ends
     * @param lifetimeTicks lifetime in game ticks; must be positive
     * @return this item for fluent configuration
     * @throws IllegalArgumentException if the lifetime is not positive
     */
    public ExpiringItem expiresTo(final Item replacement, final int lifetimeTicks) {
        if (lifetimeTicks <= 0) {
            throw new IllegalArgumentException("lifetimeTicks must be positive");
        }
        this.replacement = replacement;
        this.lifetimeTicks = lifetimeTicks;
        return this;
    }

    /**
     * Starts or advances the item's inventory timer and replaces the stack when it expires.
     * Aging is limited to player inventories.
     */
    @Override
    public void inventoryTick(
            final ItemStack stack,
            final ServerLevel level,
            final Entity owner,
            final EquipmentSlot slot
    ) {
        if (!(owner instanceof Player player) || replacement == null) {
            return;
        }

        Long expirationTime = stack.get(ModDataComponents.EXPIRATION_TIME);
        if (expirationTime == null) {
            stack.set(ModDataComponents.EXPIRATION_TIME, level.getGameTime() + lifetimeTicks);
            return;
        }

        if (level.getGameTime() < expirationTime) {
            return;
        }

        for (int inventorySlot = 0; inventorySlot < player.getInventory().getContainerSize(); inventorySlot++) {
            if (player.getInventory().getItem(inventorySlot) == stack) {
                ItemStack replacementStack = stack.transmuteCopy(replacement);
                replacementStack.remove(ModDataComponents.EXPIRATION_TIME);
                player.getInventory().setItem(inventorySlot, replacementStack);
                return;
            }
        }
    }
}
