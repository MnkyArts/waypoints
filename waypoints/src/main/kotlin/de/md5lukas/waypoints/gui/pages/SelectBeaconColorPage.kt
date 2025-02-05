package de.md5lukas.waypoints.gui.pages

import de.md5lukas.commons.collections.LoopAroundList
import de.md5lukas.kinvs.GUIPattern
import de.md5lukas.kinvs.items.GUIContent
import de.md5lukas.kinvs.items.GUIItem
import de.md5lukas.waypoints.api.BeaconColor
import de.md5lukas.waypoints.api.Waypoint
import de.md5lukas.waypoints.gui.WaypointsGUI
import org.bukkit.inventory.ItemStack

class SelectBeaconColorPage(wpGUI: WaypointsGUI, private val waypoint: Waypoint) : BasePage(wpGUI, wpGUI.extendApi { waypoint.type.getBackgroundItem() }) {

    private companion object {
        /**
         * p = move selection to the right
         * n = move selection to the left
         * b = back
         */
        val pagePattern = GUIPattern(
            "_________",
            "_________",
            "p_#####_n",
            "_________",
            "________b",
        )
    }

    private val colors = LoopAroundList<GUIContent>(5).also { list ->
        wpGUI.translations.TEXT_BEACON_COLORS.forEach { pair ->
            val item = ItemStack(pair.first.material)
            item.itemMeta = item.itemMeta!!.also { meta ->
                meta.displayName(pair.second.text)
            }
            list.add(GUIItem(item) {
                waypoint.beaconColor = if (pair.first == BeaconColor.CLEAR) null else pair.first
                wpGUI.goBack()
            })
        }
    }

    private fun updateColorSelection(update: Boolean = true) {
        val row = 2
        colors.cutOut.forEachIndexed { index, guiContent ->
            val column = 2 + index
            grid[row][column] = guiContent
        }
        if (update) {
            wpGUI.gui.update()
        }
    }

    private fun updatePage() {
        applyPattern(
            pagePattern,
            0, 0,
            background,
            'p' to GUIItem(wpGUI.translations.SELECT_BEACON_COLOR_MOVE_LEFT.item) {
                colors.next()
                updateColorSelection()
            },
            'n' to GUIItem(wpGUI.translations.SELECT_BEACON_COLOR_MOVE_RIGHT.item) {
                colors.previous()
                updateColorSelection()
            },
            'b' to GUIItem(wpGUI.translations.GENERAL_BACK.item) {
                wpGUI.goBack()
            }
        )
    }

    init {
        updatePage()
        updateColorSelection(false)
    }
}