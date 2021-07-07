package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.state.GameState

class HandleFailedElection : StateTransition {

    override fun evaluate(state: GameState): GameState {
        val electionTracker = state.electionTracker + 1

        if (electionTracker == 3) {
            val enacted = state.drawingDeck.first()
            val drawingDeck = state.drawingDeck.drop(1)


        }

        // TODO: Pass the presidential candidacy
        return state.copy(electionTracker = electionTracker)
    }
}