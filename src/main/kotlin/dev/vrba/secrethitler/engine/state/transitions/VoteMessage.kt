package dev.vrba.secrethitler.engine.state.transitions

import dev.vrba.secrethitler.engine.GamePhase
import dev.vrba.secrethitler.engine.election.Vote
import dev.vrba.secrethitler.engine.state.GameState
import java.util.*

class VoteMessage(sender: UUID, private val vote: Vote) : TransitionMessage(sender) {

    override fun validateState(state: GameState): Boolean =
        state.phase == GamePhase.VotingForTheGovernment &&
                state.election != null

    override fun evaluate(state: GameState): GameState {
        // This is just for smart casting
        if (state.election == null) {
            return state
        }

        val election = state.election.vote(sender, vote)

        if (election.finished) {
            return state.transition(
                if (election.successful) HandleSuccessfulElection()
                else HandleFailedElection()
            )
        }

        return state.copy(election = election)
    }
}