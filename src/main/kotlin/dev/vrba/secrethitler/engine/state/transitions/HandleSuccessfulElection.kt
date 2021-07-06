package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.state.GameState

class HandleSuccessfulElection : StateTransition {
    override fun evaluate(state: GameState): GameState {
        return state
    }
}