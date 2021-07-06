package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.state.GameState
import java.util.*

abstract class TransitionMessage(protected val sender: UUID) : StateTransition {

    abstract fun validateState(state: GameState): Boolean

    override fun validate(state: GameState): Boolean =
        state.playing &&
        state.players.containsKey(sender) &&
        state.players[sender]!!.alive &&
        // Custom validation logic for each message
        validateState(state)
}