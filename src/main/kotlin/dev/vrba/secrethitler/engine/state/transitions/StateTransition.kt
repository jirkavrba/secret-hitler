package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.state.GameState

interface StateTransition {
    fun validate(state: GameState): Boolean = true
    fun evaluate(state: GameState): GameState
}