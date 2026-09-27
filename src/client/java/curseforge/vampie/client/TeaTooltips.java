package curseforge.vampie.client;

import com.mojang.blaze3d.platform.InputConstants;
import curseforge.vampie.item.ModItems;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.Map;

public final class TeaTooltips {
    private static final Map<Item, TooltipText> TEA_TOOLTIPS = Map.of(
            ModItems.SENCHA_TEA, new TooltipText("tooltip.teatheory.sencha.description", "tooltip.teatheory.sencha.effect"),
            ModItems.FUKAMUSHICHA_SENCHA_TEA, new TooltipText("tooltip.teatheory.fukamushicha.description", "tooltip.teatheory.fukamushicha.effect"),
            ModItems.MATCHA_TEA, new TooltipText("tooltip.teatheory.matcha.description", "tooltip.teatheory.matcha.effect"),
            ModItems.HOJICHA_TEA, new TooltipText("tooltip.teatheory.hojicha.description", "tooltip.teatheory.hojicha.effect"),
            ModItems.OOLONG_TEA, new TooltipText("tooltip.teatheory.oolong.description", "tooltip.teatheory.oolong.effect"),
            ModItems.BLACK_TEA, new TooltipText("tooltip.teatheory.black.description", "tooltip.teatheory.black.effect"),
            ModItems.BLACK_TEA_MILK, new TooltipText("tooltip.teatheory.black_milk.description", "tooltip.teatheory.black_milk.effect"),
            ModItems.SILVER_NEEDLE_TEA, new TooltipText("tooltip.teatheory.silver_needle.description", "tooltip.teatheory.silver_needle.effect")
    );

    private TeaTooltips() {
    }

    public static void register() {
        ItemTooltipCallback.EVENT.register((stack, context, flag, lines) -> {
            TooltipText text = TEA_TOOLTIPS.get(stack.getItem());
            if (text == null) {
                return;
            }

            if (InputConstants.isKeyDown(InputConstants.KEY_LSHIFT) || InputConstants.isKeyDown(InputConstants.KEY_RSHIFT)) {
                lines.add(Component.translatable(text.descriptionKey()).withStyle(ChatFormatting.GRAY));
                lines.add(Component.translatable(text.effectKey()).withStyle(ChatFormatting.GREEN));
            } else {
                lines.add(Component.translatable("tooltip.teatheory.hold_shift").withStyle(ChatFormatting.DARK_GRAY));
            }
        });
    }

    private record TooltipText(String descriptionKey, String effectKey) {
    }
}
