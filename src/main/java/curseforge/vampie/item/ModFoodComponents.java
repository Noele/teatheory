package curseforge.vampie.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodProperties TEA_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(6)
            .alwaysEdible()
            .saturationModifier(5)
            .build();

    public static Consumable teaWithEffect(
            final Holder<MobEffect> effect,
            final int durationTicks,
            final int amplifier
    ) {
        return Consumable.builder()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, durationTicks, amplifier)))
                .animation(ItemUseAnimation.DRINK)
                .sound(SoundEvents.GENERIC_DRINK)
                .consumeSeconds(2)
                .hasConsumeParticles(false)
                .build();
    }
}
