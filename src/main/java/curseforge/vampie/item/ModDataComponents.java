package curseforge.vampie.item;

import curseforge.vampie.TeaTheory;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

public final class ModDataComponents {
    public static DataComponentType<Long> EXPIRATION_TIME;

    private ModDataComponents() {
    }

    public static void register() {
        EXPIRATION_TIME = Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                TeaTheory.id("expiration_time"),
                DataComponentType.<Long>builder()
                        .persistent(com.mojang.serialization.Codec.LONG)
                        .networkSynchronized(ByteBufCodecs.VAR_LONG)
                        .build()
        );
    }
}
