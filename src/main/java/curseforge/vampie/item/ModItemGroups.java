package curseforge.vampie.item;

import curseforge.vampie.TeaTheory;

import curseforge.vampie.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.stream.Stream;

public class ModItemGroups {

    public final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), TeaTheory.id("creativetab.items")
    );
    public final CreativeModeTab CUSTOM_CREATIVE_TAB;

    /** Registers the Tea Theory creative tab and populates it with the mod's items and blocks. */
    public ModItemGroups(ModItems modItems, ModBlocks modBlocks) {
        CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
                .icon(() -> new ItemStack(modItems.CAMELLIA_SINENSIS))
                .title(Component.translatable(TeaTheory.MOD_ID + ".creativetab.items"))
                .displayItems((params, output) -> {
                    for(Item item : Stream.concat(Arrays.stream(modItems.ALL_ITEMS), Arrays.stream(modBlocks.ALL_BLOCKS_AS_ITEMS)).toList()) {
                        output.accept(item);
                    }
                })
                .build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}
