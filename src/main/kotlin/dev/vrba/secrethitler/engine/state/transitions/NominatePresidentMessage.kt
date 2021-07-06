package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.GamePhase
import dev.vrba.secrethitler.engine.state.GameState
import dev.vrba.secrethitler.original.election.Government
import java.util.*

class NominatePresidentMessage(sender: UUID, private val selected: UUID) : TransitionMessage(sender) {
    override fun validateState(state: GameState): Boolean =
        state.phase == GamePhase.PresidentIsNominatingTheNextPresident &&
                sender == state.government.president &&
                selected in state.playersAlive &&
                selected != sender

    override fun evaluate(state: GameState): GameState =
        state.copy(
            phase = GamePhase.PresidentIsNominatingChancellor,
            government = Government(selected),
            lastElectedGovernment = state.government,
        )
}