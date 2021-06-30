package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.state.GameState;
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
        // TODO: Implement this
        return state;
    }
}
