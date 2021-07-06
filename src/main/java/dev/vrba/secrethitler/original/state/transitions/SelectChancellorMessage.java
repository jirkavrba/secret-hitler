package dev.vrba.secrethitler.original.state.transitions;

import dev.vrba.secrethitler.original.Phase;
import dev.vrba.secrethitler.original.election.Election;
import dev.vrba.secrethitler.original.election.Government;
import dev.vrba.secrethitler.original.state.GameState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SelectChancellorMessage extends GameStateMessage {

    private final UUID selected;

    protected SelectChancellorMessage(@NotNull UUID sender, @NotNull UUID selected) {
        super(sender);
        this.selected = selected;
    }

    @Override
    protected boolean validateState(@NotNull GameState state) {
                // The phase is correct
        return state.getPhase() == Phase.PRESIDENT_IS_SELECTING_CHANCELLOR &&
                // The sender is president
                state.getGovernment().getPresident().equals(this.sender) &&
                // Selected player is an eligible chancellor candidate
                state.getEligibleChancellorCandidates().contains(this.selected);
    }

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        return state.withPhase(Phase.VOTING_FOR_THE_GOVERNMENT)
                .withElection(new Election(state.getPlayers().keySet()))
                .withGovernment(new Government(state.getGovernment().getPresident(), this.selected));
    }
}
