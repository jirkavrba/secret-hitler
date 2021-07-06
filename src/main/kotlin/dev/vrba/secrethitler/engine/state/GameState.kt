package dev.vrba.secrethitler.engine.state

import dev.vrba.secrethitler.engine.GamePhase
import dev.vrba.secrethitler.engine.Party
import dev.vrba.secrethitler.engine.election.Election
import dev.vrba.secrethitler.engine.election.Vote
import dev.vrba.secrethitler.original.EnactedPolicies
import dev.vrba.secrethitler.original.election.Government
import java.security.Policy
import java.util.*

data class PublicGameState(
    val playing: Boolean,
    val phase: GamePhase,
    val players: Map<UUID, PublicPlayerState>,
    val enactedPolicies: EnactedPolicies,
    val electionTracker: Int,
    val drawingDeckCards: Int,
    val discardingDeckCards: Int,
    val government: Government,
    val lastElectedGovernment: Government?,
    val election: Map<UUID, Vote>?,
    val winners: Party?
)

data class GameState(
    val playing: Boolean,
    val phase: GamePhase,
    val players: Map<UUID, PlayerState>,
    val enactedPolicies: EnactedPolicies,
    val electionTracker: Int,
    val drawingDeck: List<Policy>,
    val discardingDeck: List<Policy>,
    val governmentPolicyPool: List<Policy>,
    val government: Government,
    val lastElectedGovernment: Government?,
    val election: Election?,
    val winners: Party?
) {
    fun public(): PublicGameState =
        PublicGameState(
            playing,
            phase,
            players.mapValues { it.value.public(!playing) },
            enactedPolicies,
            electionTracker,
            drawingDeck.size,
            discardingDeck.size,
            government,
            lastElectedGovernment,
            election?.masked,
            winners
        )
}