package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.election.Vote;
import dev.vrba.secrethitler.engine.state.GameState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class VoteMessage extends GameStateMessage {

    private final Vote vote;

    protected VoteMessage(@NotNull UUID sender, @NotNull Vote vote) {
        super(sender);
        this.vote = vote;
    }

    @Override
    protected boolean validateState(@NotNull GameState state) {
        return state.getPhase() == Phase.VOTING_FOR_THE_GOVERNMENT;
    }

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        return state;
    }
}
