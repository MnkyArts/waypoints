package de.md5lukas.waypoints.display;

import de.md5lukas.commons.inventory.ItemBuilder;
import de.md5lukas.waypoints.Messages;
import de.md5lukas.waypoints.store.WPConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static de.md5lukas.waypoints.Messages.*;

public enum BlockColor {

	CLEAR(null, INVENTORY_SELECT_BEACON_COLOR_CLEAR_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_CLEAR_DESCRIPTION),
	LIGHT_GRAY(Material.LIGHT_GRAY_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_LIGHT_GRAY_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_LIGHT_GRAY_DESCRIPTION),
	GRAY(Material.GRAY_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_GRAY_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_GRAY_DESCRIPTION),
	PINK(Material.PINK_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_PINK_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_PINK_DESCRIPTION),
	LIME(Material.LIME_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_LIME_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_LIME_DESCRIPTION),
	YELLOW(Material.YELLOW_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_YELLOW_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_YELLOW_DESCRIPTION),
	LIGHT_BLUE(Material.LIGHT_BLUE_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_LIGHT_BLUE_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_LIGHT_BLUE_DESCRIPTION),
	MAGENTA(Material.MAGENTA_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_MAGENTA_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_MAGENTA_DESCRIPTION),
	ORANGE(Material.ORANGE_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_ORANGE_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_ORANGE_DESCRIPTION),
	WHITE(Material.WHITE_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_WHITE_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_WHITE_DESCRIPTION),
	BLACK(Material.BLACK_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_BLACK_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_BLACK_DESCRIPTION),
	RED(Material.RED_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_RED_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_RED_DESCRIPTION),
	GREEN(Material.GREEN_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_GREEN_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_GREEN_DESCRIPTION),
	BROWN(Material.BROWN_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_BROWN_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_BROWN_DESCRIPTION),
	BLUE(Material.BLUE_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_BLUE_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_BLUE_DESCRIPTION),
	CYAN(Material.CYAN_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_CYAN_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_CYAN_DESCRIPTION),
	PURPLE(Material.PURPLE_STAINED_GLASS, INVENTORY_SELECT_BEACON_COLOR_PURPLE_DISPLAY_NAME, INVENTORY_SELECT_BEACON_COLOR_PURPLE_DESCRIPTION),
	;

	private String config;
	private Material material;
	private Messages displayName, description;
	private BlockData blockData;

	BlockColor(Material material, Messages displayName, Messages description) {
		this.material = material;
		this.displayName = displayName;
		this.description = description;
		if (material != null)
			this.blockData = Bukkit.createBlockData(material);
	}

	public Material getMaterial() {
		return material;
	}

	public ItemStack asInventoryItem(Player p) {
		return new ItemBuilder(material).name(displayName.getRaw(p)).lore(description.getRaw(p), WPConfig.inventory().getMaxDescriptionLineLength()).make();
	}

	public BlockData getBlockData() {
		return blockData;
	}
}
