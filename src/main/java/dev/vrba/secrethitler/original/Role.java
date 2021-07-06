package dev.vrba.secrethitler.original;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum Role {
    HITLER(Party.FASCIST),
    FASCIST(Party.FASCIST),
    LIBERAL(Party.LIBERAL),
    HIDDEN(Party.HIDDEN);

    @Getter
    private final Party partyMembership;

    Role(@NotNull Party partyMembership) {
        this.partyMembership = partyMembership;
    }

    public static @NotNull List<Role> createPool(int players) {
        return switch (players) {
            case 5 -> createPool(3, 1);
            case 6 -> createPool(4, 1);
            case 7 -> createPool(4, 2);
            case 8 -> createPool(5, 2);
            case 9 -> createPool(5, 3);
            case 10 -> createPool(6, 3);
            default -> throw new IllegalArgumentException("Number of players must be between 5 and 10 inclusive!");
        };
    }

    private static @NotNull List<Role> createPool(int liberals, int fascists) {
        List<Role> pool = new ArrayList<>();

        pool.add(Role.HITLER);
        pool.addAll(Stream.generate(() -> Role.FASCIST).limit(fascists).toList());
        pool.addAll(Stream.generate(() -> Role.LIBERAL).limit(liberals).toList());

        Collections.shuffle(pool);

        return pool;
    }
}
