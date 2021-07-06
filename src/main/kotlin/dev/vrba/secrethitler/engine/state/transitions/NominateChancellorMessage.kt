package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.GamePhase
import dev.vrba.secrethitler.engine.election.createElection
import dev.vrba.secrethitler.engine.state.GameState
import dev.vrba.secrethitler.original.election.Government
import java.util.*

class NominateChancellorMessage(sender: UUID, private val selected: UUID) : TransitionMessage(sender) {
    override fun validateState(state: GameState): Boolean =
        state.phase == GamePhase.PresidentIsNominatingChancellor &&
        sender == state.government.president &&
        sender in state.eligibleChancellorCandidates

    override fun evaluate(state: GameState): GameState =
        state.copy(
            phase = GamePhase.VotingForTheGovernment,
            government = Government(state.government.president, selected),
            election = createElection(state.players.keys)
        )
}