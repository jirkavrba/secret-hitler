package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.original.state.GameState

interface StateTransition {
    fun validate(state: GameState): Boolean = true
    fun evaluate(state: GameState): GameState
}