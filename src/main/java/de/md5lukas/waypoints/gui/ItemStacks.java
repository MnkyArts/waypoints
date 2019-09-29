/*
 *     Waypoints2, A plugin for spigot to add waypoints functionality
 *     Copyright (C) 2019  Lukas Planz
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.md5lukas.waypoints.gui;

import de.md5lukas.commons.inventory.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static de.md5lukas.waypoints.Messages.*;
import static de.md5lukas.waypoints.Waypoints.message;
import static de.md5lukas.waypoints.store.WPConfig.inventory;

class ItemStacks {

	static ItemStack getPreviousItem(Player p) {
		return new ItemBuilder(inventory().getGeneralPreviousItem()).name(message(INVENTORY_GENERAL_PREVIOUS_DISPLAY_NAME, p))
			.lore(message(INVENTORY_GENERAL_PREVIOUS_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getNextItem(Player p) {
		return new ItemBuilder(inventory().getGeneralNextItem()).name(message(INVENTORY_GENERAL_NEXT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_GENERAL_NEXT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getBackItem(Player p) {
		return new ItemBuilder(inventory().getGeneralBackItem()).name(message(INVENTORY_GENERAL_BACK_DISPLAY_NAME, p))
			.lore(message(INVENTORY_GENERAL_BACK_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getOverviewBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getOverviewBackgroundItem()).name(message(INVENTORY_OVERVIEW_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_OVERVIEW_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getOverviewDeselectItem(Player p) {
		return new ItemBuilder(inventory().getOverviewDeselectItem()).name(message(INVENTORY_OVERVIEW_DESELECT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_OVERVIEW_DESELECT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getOverviewToggleGlobalsShownItem(Player p) {
		return new ItemBuilder(inventory().getOverviewToggleGlobalsItem()).name(message(INVENTORY_OVERVIEW_TOGGLE_GLOBALS_SHOWN_DISPLAY_NAME, p))
			.lore(message(INVENTORY_OVERVIEW_TOGGLE_GLOBALS_SHOWN_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getOverviewToggleGlobalsHiddenItem(Player p) {
		return new ItemBuilder(inventory().getOverviewToggleGlobalsItem()).name(message(INVENTORY_OVERVIEW_TOGGLE_GLOBALS_HIDDEN_DISPLAY_NAME, p))
			.lore(message(INVENTORY_OVERVIEW_TOGGLE_GLOBALS_HIDDEN_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointDeathBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getWaypointDeathBackgroundItem()).name(message(INVENTORY_WAYPOINT_DEATH_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_DEATH_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointDeathSelectItem(Player p) {
		return new ItemBuilder(inventory().getWaypointDeathSelectItem()).name(message(INVENTORY_WAYPOINT_DEATH_SELECT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_DEATH_SELECT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	public static ItemStack getWaypointDeathTeleportItem(Player p) {
		return new ItemBuilder(inventory().getWaypointDeathTeleportItem()).name(message(INVENTORY_WAYPOINT_DEATH_TELEPORT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_DEATH_TELEPORT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateBackgroundItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateSelectItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateSelectItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_SELECT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_SELECT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateDeleteItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateDeleteItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_DELETE_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_DELETE_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateRenameItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateRenameItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_RENAME_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_RENAME_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateMoveToFolderItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateMoveToFolderItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_MOVE_TO_FOLDER_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_MOVE_TO_FOLDER_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPrivateTeleportItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPrivateTeleportItem()).name(message(INVENTORY_WAYPOINT_PRIVATE_TELEPORT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PRIVATE_TELEPORT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}


	static ItemStack getWaypointPublicBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPublicBackgroundItem()).name(message(INVENTORY_WAYPOINT_PUBLIC_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PUBLIC_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPublicSelectItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPublicSelectItem()).name(message(INVENTORY_WAYPOINT_PUBLIC_SELECT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PUBLIC_SELECT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPublicDeleteItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPublicDeleteItem()).name(message(INVENTORY_WAYPOINT_PUBLIC_DELETE_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PUBLIC_DELETE_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPublicRenameItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPublicRenameItem()).name(message(INVENTORY_WAYPOINT_PUBLIC_RENAME_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PUBLIC_RENAME_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPublicTeleportItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPublicTeleportItem()).name(message(INVENTORY_WAYPOINT_PUBLIC_TELEPORT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PUBLIC_TELEPORT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPermissionBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPermissionBackgroundItem()).name(message(INVENTORY_WAYPOINT_PERMISSION_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PERMISSION_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPermissionSelectItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPermissionSelectItem()).name(message(INVENTORY_WAYPOINT_PERMISSION_SELECT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PERMISSION_SELECT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPermissionDeleteItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPermissionDeleteItem()).name(message(INVENTORY_WAYPOINT_PERMISSION_DELETE_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PERMISSION_DELETE_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPermissionRenameItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPermissionRenameItem()).name(message(INVENTORY_WAYPOINT_PERMISSION_RENAME_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PERMISSION_RENAME_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getWaypointPermissionTeleportItem(Player p) {
		return new ItemBuilder(inventory().getWaypointPermissionTeleportItem()).name(message(INVENTORY_WAYPOINT_PERMISSION_TELEPORT_DISPLAY_NAME, p))
			.lore(message(INVENTORY_WAYPOINT_PERMISSION_TELEPORT_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getSelectFolderBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getSelectFolderBackgroundItem()).name(message(INVENTORY_SELECT_FOLDER_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_SELECT_FOLDER_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getSelectFolderNoFolderItem(Player p) {
		return new ItemBuilder(inventory().getSelectFolderNoFolderItem()).name(message(INVENTORY_SELECT_FOLDER_NO_FOLDER_DISPLAY_NAME, p))
			.lore(message(INVENTORY_SELECT_FOLDER_NO_FOLDER_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getFolderPrivateBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getFolderPrivateBackgroundItem()).name(message(INVENTORY_FOLDER_PRIVATE_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_FOLDER_PRIVATE_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getFolderPrivateDeleteItem(Player p) {
		return new ItemBuilder(inventory().getFolderPrivateDeleteItem()).name(message(INVENTORY_FOLDER_PRIVATE_DELETE_DISPLAY_NAME, p))
			.lore(message(INVENTORY_FOLDER_PRIVATE_DELETE_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getFolderPrivateRenameItem(Player p) {
		return new ItemBuilder(inventory().getFolderPrivateRenameItem()).name(message(INVENTORY_FOLDER_PRIVATE_RENAME_DISPLAY_NAME, p))
			.lore(message(INVENTORY_FOLDER_PRIVATE_RENAME_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getFolderPublicBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getFolderPrivateBackgroundItem()).name(message(INVENTORY_FOLDER_PUBLIC_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_FOLDER_PUBLIC_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}

	static ItemStack getFolderPermissionBackgroundItem(Player p) {
		return new ItemBuilder(inventory().getFolderPrivateBackgroundItem()).name(message(INVENTORY_FOLDER_PERMISSION_BACKGROUND_DISPLAY_NAME, p))
			.lore(message(INVENTORY_FOLDER_PERMISSION_BACKGROUND_DESCRIPTION, p), inventory().getMaxDescriptionLineLength()).make();
	}
}
