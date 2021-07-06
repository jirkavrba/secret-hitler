package dev.vrba.secrethitler.original.state.transitions;

import dev.vrba.secrethitler.original.Phase;
import dev.vrba.secrethitler.original.election.Government;
import dev.vrba.secrethitler.original.state.GameState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SelectNextPresidentMessage extends GameStateMessage {

    private final UUID selected;

    protected SelectNextPresidentMessage(@NotNull UUID sender, @NotNull UUID selected) {
        super(sender);
        this.selected = selected;
    }

    @Override
    protected boolean validateState(@NotNull GameState state) {
        // The phase is correct
        return state.getPhase() == Phase.PRESIDENT_IS_SELECTING_THE_NEXT_PRESIDENT &&
                // The message was sent by the current president
                state.getGovernment().getPresident().equals(this.sender) &&
                // The selected player is playing and alive
                state.getPlayers().containsKey(this.selected) &&
                state.getPlayers().get(this.selected).isAlive() &&
                // The selected president is not the current president
                !state.getGovernment().getPresident().equals(this.selected);
    }

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        return state
                .withLastElectedGovernment(state.getGovernment())
                .withGovernment(new Government(this.selected))
                .withPhase(Phase.PRESIDENT_IS_SELECTING_CHANCELLOR);
    }
}
