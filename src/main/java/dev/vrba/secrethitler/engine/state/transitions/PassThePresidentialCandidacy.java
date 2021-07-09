package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.election.Government;
import dev.vrba.secrethitler.engine.state.GameState;
import dev.vrba.secrethitler.engine.state.PlayerState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PassThePresidentialCandidacy implements StateTransition {

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        List<UUID> playersAlive = state.getPlayers().values().stream()
                .filter(PlayerState::isAlive)
                .map(PlayerState::getId)
                .toList();

        // Move the presidential candidacy to the next player, that is still alive
        UUID current = state.getGovernment().getPresident();
        UUID next = playersAlive.get((playersAlive.indexOf(current) + 1) % playersAlive.size());

        Map<UUID, PlayerState> players = state.getPlayers();

        // Set eligible chancellor candidates
        players.put(next, players.get(next).withAvailablePlayerTargets(state.getEligibleChancellorCandidates()));

        // Set the current government (the last elected government is not handled)
        return state.withGovernment(new Government(next))
                .withPhase(Phase.PRESIDENT_IS_SELECTING_CHANCELLOR)
                .withPlayers(players);
    }
}
