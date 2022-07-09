package de.md5lukas.waypoints.gui.pages

import de.md5lukas.commons.MathHelper
import de.md5lukas.commons.collections.PaginationList
import de.md5lukas.kinvs.GUIPattern
import de.md5lukas.kinvs.items.GUIItem
import de.md5lukas.waypoints.WaypointsPermissions
import de.md5lukas.waypoints.gui.WaypointsGUI
import de.md5lukas.waypoints.gui.items.TrackableToggleItem
import de.md5lukas.waypoints.util.format
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.SkullMeta
import java.util.*

class PlayerTrackingPage(
    wpGUI: WaypointsGUI,
) : ListingPage<Player>(
    wpGUI,
    wpGUI.translations.TRACKING_BACKGROUND.item,
    {
        val list = PaginationList<Player>(PAGINATION_LIST_PAGE_SIZE)
        val toggleable = wpGUI.plugin.waypointsConfig.playerTracking.toggleable
        val canTrackAll = wpGUI.viewer.hasPermission(WaypointsPermissions.TRACKING_TRACK_ALL)

        val api = wpGUI.plugin.api

        wpGUI.plugin.server.onlinePlayers.forEach {
            if (it === wpGUI.viewer) {
                return@forEach
            }
            if (canTrackAll || !toggleable || api.getWaypointPlayer(it.uniqueId).canBeTracked) {
                list.add(it)
            }
        }
        list
    },
    { player ->
        GUIItem(
            wpGUI.translations.TRACKING_PLAYER.getItem(
                mapOf(
                    "name" to player.displayName,
                    "world" to wpGUI.plugin.worldTranslations.getWorldName(player.world),
                    "x" to player.location.x.format(),
                    "y" to player.location.y.format(),
                    "z" to player.location.z.format(),
                    "blockX" to player.location.blockX.toString(),
                    "blockY" to player.location.blockY.toString(),
                    "blockZ" to player.location.blockZ.toString(),
                    "distance" to if (wpGUI.viewer.world === player.world) {
                        MathHelper.distance2D(wpGUI.viewer.location, player.location).format()
                    } else {
                        wpGUI.translations.TEXT_DISTANCE_OTHER_WORLD.text
                    }
                )
            ).also { stack ->
                stack.itemMeta = (stack.itemMeta!! as SkullMeta).also { meta ->
                    meta.owningPlayer = player
                }
            }
        ) {
            if (!wpGUI.viewerData.canBeTracked && wpGUI.plugin.waypointsConfig.playerTracking.trackingRequiresTrackable) {
                wpGUI.translations.MESSAGE_TRACKING_TRACKABLE_REQUIRED.send(wpGUI.viewer)
            } else if (!player.isOnline) {
                wpGUI.translations.MESSAGE_TRACKING_PLAYER_NO_LONGER_ONLINE.send(wpGUI.viewer)
            } else {
                wpGUI.viewer.closeInventory()
                wpGUI.plugin.api.pointerManager.let {
                    it.enable(wpGUI.viewer, it.trackableOf(player))
                }
                if (wpGUI.plugin.waypointsConfig.playerTracking.notification) {
                    wpGUI.translations.MESSAGE_TRACKING_NOTIFICATION.send(player, Collections.singletonMap("name", wpGUI.viewer.displayName))
                }
            }

        }

    }
) {

    private companion object {

        /**
         * p = previous
         * t = Toggle trackable
         * r = Refresh players
         * b = Back
         * n = Next
         */
        val controlsPattern = GUIPattern("p_t_r_b_n")
    }

    override fun update() {
        updateListingContent()
        updateControls()
    }

    private fun updateControls(update: Boolean = true) {
        applyPattern(
            controlsPattern,
            4,
            0,
            background,
            'p' to GUIItem(wpGUI.translations.GENERAL_PREVIOUS.item) {
                previousPage()
            },
            't' to if (wpGUI.plugin.waypointsConfig.playerTracking.toggleable) {
                TrackableToggleItem(wpGUI)
            } else {
                background
            },
            'r' to GUIItem(wpGUI.translations.TRACKING_REFRESH_LISTING.item) {
                updateListingContent()
            },
            'b' to GUIItem(wpGUI.translations.GENERAL_BACK.item) {
                wpGUI.goBack()
            },
            'n' to GUIItem(wpGUI.translations.GENERAL_NEXT.item) {
                nextPage()
            },
        )

        if (update) {
            wpGUI.gui.update()
        }
    }

    init {
        updateListingInInventory()
        updateControls(false)
    }
}