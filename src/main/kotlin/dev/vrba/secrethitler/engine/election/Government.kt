package dev.vrba.secrethitler.engine.election

import java.util.*

data class Government(val president: UUID, val chancellor: UUID?) {

    fun nominate(chancellor: UUID): Government = Government(president, chancellor)

    operator fun contains(player: UUID): Boolean = player in listOf(president, chancellor)
}
