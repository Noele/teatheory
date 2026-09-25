package curseforge.vampie.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodProperties FUKAMUSHICHA_SENCHA_TEA_FOODPROPERTIES = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(5)
            .build();

    public static final Consumable FUKAMUSHICHA_SENCHA_TEA_CONSUMABLE =
            Consumable.builder()
                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1)))
                    .animation(ItemUseAnimation.DRINK)
                    .sound(SoundEvents.GENERIC_DRINK)
                    .consumeSeconds(2)
                    .hasConsumeParticles(false)
                    .build();
}
