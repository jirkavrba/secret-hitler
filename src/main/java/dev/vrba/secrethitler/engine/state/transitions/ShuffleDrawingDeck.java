package dev.vrba.secrethitler.engine.state.transitions;

import dev.vrba.secrethitler.engine.Party;
import dev.vrba.secrethitler.engine.state.GameState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDrawingDeck implements StateTransition {
    @Override
    public boolean validate(@NotNull GameState state) {
        return true;
    }

    @Override
    public @NotNull GameState apply(@NotNull GameState state) {
        if (state.getDrawingDeck().size() <= 2) {
            List<Party> deck = new ArrayList<>();

            deck.addAll(state.getDrawingDeck());
            deck.addAll(state.getDiscardingDeck());

            Collections.shuffle(deck);

            return state
                    .withDrawingDeck(deck)
                    .withDiscardingDeck(new ArrayList<>());
        }

        return state;
    }
}
