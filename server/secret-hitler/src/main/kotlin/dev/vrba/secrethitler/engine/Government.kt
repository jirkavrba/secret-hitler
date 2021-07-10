package dev.vrba.secrethitler.engine

import java.util.*

data class Government(val president: UUID, val chancellor: UUID? = null) {
    fun nominate(chancellor: UUID): Government = copy(chancellor = chancellor)
}