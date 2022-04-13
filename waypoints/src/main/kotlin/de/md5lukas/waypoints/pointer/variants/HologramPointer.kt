package de.md5lukas.waypoints.pointer.variants

import de.md5lukas.waypoints.WaypointsPlugin
import de.md5lukas.waypoints.api.Trackable
import de.md5lukas.waypoints.api.Waypoint
import de.md5lukas.waypoints.config.pointers.HologramConfiguration
import de.md5lukas.waypoints.pointer.Pointer
import de.md5lukas.waypoints.util.Hologram
import de.md5lukas.waypoints.util.HologramManager
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

class HologramPointer(
    plugin: WaypointsPlugin,
    private val config: HologramConfiguration
) : Pointer(plugin, config.interval) {

    private val hologramManager = HologramManager(plugin)

    private val activeHolograms: MutableMap<UUID, Hologram> = HashMap()

    override fun update(player: Player, trackable: Trackable, translatedTarget: Location?) {
        if (trackable !is Waypoint)
            return
        if (translatedTarget !== null) {
            if (player.location.distanceSquared(translatedTarget) < config.maxDistance) {
                activeHolograms.computeIfAbsent(player.uniqueId) {
                    plugin.apiExtensions.run {
                        hologramManager.createHologram(translatedTarget, trackable.getHologramName())
                    }
                }.spawn(player)
            }
        }
    }

    override fun hide(player: Player, trackable: Trackable, translatedTarget: Location?) {
        if (trackable !is Waypoint)
            return
        activeHolograms.remove(player.uniqueId)?.destroy(player)
    }
}