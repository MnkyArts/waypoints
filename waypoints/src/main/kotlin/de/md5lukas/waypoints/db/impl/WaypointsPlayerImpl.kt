package de.md5lukas.waypoints.db.impl

import de.md5lukas.jdbc.selectFirst
import de.md5lukas.jdbc.update
import de.md5lukas.waypoints.api.Folder
import de.md5lukas.waypoints.api.OverviewSort
import de.md5lukas.waypoints.api.Type
import de.md5lukas.waypoints.api.WaypointsPlayer
import de.md5lukas.waypoints.db.DatabaseManager
import de.md5lukas.waypoints.util.runTaskAsync
import org.bukkit.Location
import java.sql.ResultSet
import java.time.OffsetDateTime
import java.util.*

internal class WaypointsPlayerImpl private constructor(
    dm: DatabaseManager,
    override val id: UUID,
    showGlobals: Boolean,
    sortBy: OverviewSort,
) : WaypointHolderImpl(dm, Type.PRIVATE, id), WaypointsPlayer {

    constructor(dm: DatabaseManager, row: ResultSet) : this(
        dm = dm,
        id = UUID.fromString(row.getString("id")),
        showGlobals = row.getBoolean("showGlobals"),
        sortBy = OverviewSort.valueOf(row.getString("sortBy")),
    )

    override var showGlobals: Boolean = showGlobals
        set(value) {
            field = value
            set("showGlobals", value)
        }
    override var sortBy: OverviewSort = sortBy
        set(value) {
            field = value
            set("sortBy", value.name)
        }

    override fun setCooldownUntil(type: Type, cooldownUntil: OffsetDateTime) {
        val until = cooldownUntil.toString()
        dm.connection.update(
            "INSERT INTO player_cooldown(playerId, type, cooldownUntil) VALUES (?, ?, ?) ON CONFLICT(playerId, type) DO UPDATE SET cooldownUntil = ?;",
            id.toString(),
            type.name,
            until,
            until,
        )
    }

    override fun getCooldownUntil(type: Type): OffsetDateTime? = dm.connection.selectFirst(
        "SELECT cooldownUntil FROM player_cooldown WHERE playerId = ? AND type = ?;",
        id.toString(),
        type.name,
    ) {
        OffsetDateTime.parse(getString("cooldownUntil"))
    }

    override fun addDeathLocation(location: Location) {
        super.createWaypointTyped("", location, Type.DEATH)
    }

    override val deathFolder: Folder = DeathFolderImpl(dm, id)

    private fun set(column: String, value: Any?) {
        dm.plugin.runTaskAsync {
            dm.connection.update("UPDATE player_data SET $column = ? WHERE id = ?;", value, id)
        }
    }
}