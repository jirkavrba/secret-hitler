package dev.vrba.secrethitler.original.state.transitions;

import dev.vrba.secrethitler.original.state.GameState;
import org.jetbrains.annotations.NotNull;

public interface StateTransition {

    default boolean validate(@NotNull GameState state) {
        return true;
    }

    @NotNull GameState apply(@NotNull GameState state);
}
