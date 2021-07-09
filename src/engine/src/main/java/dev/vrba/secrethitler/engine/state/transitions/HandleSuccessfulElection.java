package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Party;
import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.Role;
import dev.vrba.secrethitler.engine.state.GameState;
import dev.vrba.secrethitler.engine.state.PlayerState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HandleSuccessfulElection implements StateTransition {

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        // Check for Hitler being elected as the chancellor
        UUID hitler = state.getPlayers().values().stream()
                .filter(player -> player.getRole() == Role.HITLER)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no player with Hitler role"))
                .getId();

        if (state.getEnactedPolicies().getFascist() >= 3 && state.getGovernment().getChancellor().equals(hitler)) {
            return state
                    .withPhase(Phase.GAME_ENDED)
                    .withWinners(Party.FASCIST);
        }

        // TODO: Check docs for better methods available for this purpose
        List<Party> pool = state.getDrawingDeck().stream().limit(3).toList();
        List<Party> deck = state.getDrawingDeck().stream().skip(3).toList();

        Map<UUID, PlayerState> players = state.getPlayers();

        // Propagate government policy pool to presidential private state
        UUID president = state.getGovernment().getPresident();

        players.put(president, players.get(president).withAvailablePolicies(pool));

        return state
                .withPhase(Phase.PRESIDENT_IS_SELECTING_POLICY)
                .withDrawingDeck(deck)
                .withPlayers(players)
                .withGovernmentPolicyPool(pool)
                .withElectionTracker(0)
                .withElection(null)
                .apply(ShuffleDrawingDeck::new);
    }
}
