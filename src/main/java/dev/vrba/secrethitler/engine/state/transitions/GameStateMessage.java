package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.state.GameState;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class GameStateMessage implements StateTransition {

    @Getter
    private final UUID sender;

    protected GameStateMessage(@NotNull UUID sender) {
        this.sender = sender;
    }

    @Override
    public boolean validate(@NotNull GameState state) {
        // Validate that the message was sent by one of the players, that is still alive
        return state.isPlaying() &&
               state.getPlayers().containsKey(this.sender) &&
               state.getPlayers().get(this.sender).isAlive() &&
               this.validateState(state);
    }

    protected abstract boolean validateState(@NotNull GameState state);
}
