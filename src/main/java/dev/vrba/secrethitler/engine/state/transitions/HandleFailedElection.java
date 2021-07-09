package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.EnactedPolicies;
import dev.vrba.secrethitler.engine.Party;
import dev.vrba.secrethitler.engine.state.GameState;
import org.jetbrains.annotations.NotNull;

public class HandleFailedElection implements StateTransition {
    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        int electionTracker = state.getElectionTracker() + 1;

        // There has been three consecutive failed elections
        if (electionTracker == 3) {
            // The top policy is enacted automatically
            Party policy = state.getDrawingDeck().remove(0);
            EnactedPolicies policies = state.getEnactedPolicies().add(policy);

            // The election tracker is then reset
            return state
                    .withElectionTracker(0)
                    .withElection(null)
                    .withEnactedPolicies(policies)
                    .apply(PassThePresidentialCandidacy::new)
                    .apply(CheckPoliciesForWinnerParty::new);
        }

        return state
                .withElection(null)
                .withElectionTracker(0)
                .apply(PassThePresidentialCandidacy::new);
    }
}
