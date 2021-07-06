package dev.vrba.secrethitler.original.state.transitions;

import dev.vrba.secrethitler.original.EnactedPolicies;
import dev.vrba.secrethitler.original.Party;
import dev.vrba.secrethitler.original.Phase;
import dev.vrba.secrethitler.original.state.GameState;
import org.jetbrains.annotations.NotNull;

public class CheckPoliciesForWinnerParty implements StateTransition {
    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        if (state.getEnactedPolicies().getFascist() == EnactedPolicies.REQUIRED_FASCIST_POLICIES) {
            return state
                    .withPhase(Phase.GAME_ENDED)
                    .withWinners(Party.FASCIST);
        }

        if (state.getEnactedPolicies().getLiberal() == EnactedPolicies.REQUIRED_LIBERAL_POLICIES) {
            return state
                    .withPhase(Phase.GAME_ENDED)
                    .withWinners(Party.LIBERAL);
        }

        return state;
    }
}

