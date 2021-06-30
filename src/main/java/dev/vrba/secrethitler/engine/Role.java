package dev.vrba.secrethitler.engine;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public enum Role {
    FASCIST(Party.FASCIST),
    LIBERAL(Party.LIBERAL),
    HIDDEN(Party.HIDDEN);

    @Getter
    private final Party partyMembership;

    Role(@NotNull Party partyMembership) {
        this.partyMembership = partyMembership;
    }
}
