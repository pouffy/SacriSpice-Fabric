package com.pouffy.sacrispice.item;

import com.pouffy.sacrispice.SacriSpice;
import com.pouffy.sacrispice.item.custom.SacrificialDaggerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item DAGGER = registerItem("sacrificial_dagger",
            new SacrificialDaggerItem(ToolMaterials.DIAMOND, 2, 1, (new Item.Settings()).fireproof().group(ModItemGroup.SACRISPICE)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SacriSpice.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SacriSpice.LOGGER.debug("Registering Mod Items for " + SacriSpice.MOD_ID);
    }
}
