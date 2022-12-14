package com.pouffy.sacrispice.item;

import com.pouffy.sacrispice.SacriSpice;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SACRISPICE = FabricItemGroupBuilder.build(
            new Identifier(SacriSpice.MOD_ID, "sacrispice"), () -> new ItemStack(ModItems.DAGGER));
}
