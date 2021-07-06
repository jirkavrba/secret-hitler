package dev.vrba.secrethitler.original.election;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public enum Vote {
    JA(1),
    NEIN(-1),
    HIDDEN(0),
    NONE(0);

    @Getter
    private final int value;

    Vote(int value) {
        this.value = value;
    }

    public @NotNull Vote mask() {
        if (this == NONE) {
            return NONE;
        }

        return HIDDEN;
    }
}
