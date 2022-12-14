package com.pouffy.sacrispice;

import com.pouffy.sacrispice.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class SacriSpice implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "sacrispice";
	public static final Logger LOGGER = LoggerFactory.getLogger("sacrispice");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		registerLootTable();
	}

	protected void registerLootTable() {
		Set<Identifier> scavengingEntityIdList = Set.of(
				EntityType.GOAT.getLootTableId()
		);

	LootTableEvents.MODIFY.register((resourceManager,lootManager,id,tableBuilder,source)->

	{
		Identifier injectId = new Identifier(SacriSpice.MOD_ID, "inject/" + id.getPath());
		if (scavengingEntityIdList.contains(id)) {
			tableBuilder.pool(LootPool.builder().with(LootTableEntry.builder(injectId)).build());
		}
	});
}
}

