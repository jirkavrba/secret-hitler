package dev.vrba.secrethitler.engine.state;

import dev.vrba.secrethitler.engine.EnactedPolicies;
import dev.vrba.secrethitler.engine.Party; import dev.vrba.secrethitler.engine.Phase; import dev.vrba.secrethitler.engine.election.Election;
import dev.vrba.secrethitler.engine.election.Government;
import dev.vrba.secrethitler.engine.election.Vote;
import dev.vrba.secrethitler.engine.state.transitions.StateTransition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@With
@Getter
@AllArgsConstructor
public class GameState {
    private final boolean playing;

    private final @NotNull Phase phase;

    private final @NotNull Map<UUID, PlayerState> players;

    private final @NotNull EnactedPolicies enactedPolicies;

    private final @NotNull List<Party> drawingDeck;

    private final @NotNull List<Party> discardingDeck;

    private final @NotNull List<Party> governmentPolicyPool;

    private final @NotNull Government government;

    private final @Nullable Government lastElectedGovernment;

    private final @Nullable Election election;

    private final @Nullable Party winners;

    public @NotNull PublicGameState toPublicState() {
        Map<UUID, PublicPlayerState> players = this.players.values()
                .stream()
                .map(PlayerState::toPublicState)
                .collect(Collectors.toMap(
                    PublicPlayerState::getId,
                    Function.identity()
                ));

        Map<UUID, Vote> election = this.election == null ? null : this.election.maskVotesUnlessFinished();

        return new PublicGameState(
                this.playing,
                this.phase,
                players,
                this.enactedPolicies,
                this.drawingDeck.size(),
                this.discardingDeck.size(),
                this.government,
                this.lastElectedGovernment,
                election,
                this.winners
        );
    }

    public @NotNull GameState applyTransition(@NotNull StateTransition transition) {
        if (transition.validate(this)) {
            return transition.apply(this);
        }

        return this;
    }

    public @NotNull Collection<UUID> getEligibleChancellorCandidates() {
        List<PlayerState> playersAlive = this.players.values()
                .stream()
                .filter(PlayerState::isAlive)
                .toList();

        // In case that 5 or less players are left in the game, term limiting is only applied to last elected chancellor
        boolean lastElectedPresidentIsEligible = playersAlive.size() <= 5;

        List<UUID> eligiblePlayers = playersAlive.stream().map(PlayerState::getId).toList();

        if (this.lastElectedGovernment != null) {
            // Last elected chancellor is always terms limited
            eligiblePlayers.remove(this.lastElectedGovernment.getChancellor());

            if (!lastElectedPresidentIsEligible) {
                eligiblePlayers.remove(this.lastElectedGovernment.getPresident());
            }
        }

        return eligiblePlayers;
    }
}
