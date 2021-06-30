package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.state.GameState;
import org.jetbrains.annotations.NotNull;

public interface StateTransition {

    boolean validate(@NotNull GameState state);

    @NotNull GameState apply(@NotNull GameState state);
}
