package dev.vrba.secrethitler.engine.election

import java.util.*

fun createElection(players: Collection<UUID>): Election = Election(players.associateWith { Vote.None })

class Election(private val votes: Map<UUID, Vote>) {

    val finished: Boolean = votes.values.none { it == Vote.None }

    val successful: Boolean = votes.values.sumOf { it.value } > 0

    val masked: Map<UUID, Vote> =
        // Only mask election if it is not finished yet
        if (finished) votes
        // When masked, all players should only distinguish, whether a given player has voted or not
        else votes.map { it.key to if (it.value == Vote.None) Vote.None else Vote.Hidden }.toMap()
}