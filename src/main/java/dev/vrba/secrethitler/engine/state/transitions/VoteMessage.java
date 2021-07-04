package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.election.Election;
import dev.vrba.secrethitler.engine.election.Vote;
import dev.vrba.secrethitler.engine.state.GameState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class VoteMessage extends GameStateMessage {

    private final Vote vote;

    protected VoteMessage(@NotNull UUID sender, @NotNull Vote vote) {
        super(sender);
        this.vote = vote;
    }

    @Override
    protected boolean validateState(@NotNull GameState state) {
        return state.getPhase() == Phase.VOTING_FOR_THE_GOVERNMENT &&
               state.getElection() != null;
    }

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        Election election = Objects.requireNonNull(state.getElection()).vote(this.sender, this.vote);

        if (election.isFinished()) {

            if (election.isSuccessful()) {
                return state.apply(HandleSuccessfulElection::new);
            }

            else {
                return state.apply(HandleFailedElection::new);
            }
        }

        return state.withElection(election);
    }
}
