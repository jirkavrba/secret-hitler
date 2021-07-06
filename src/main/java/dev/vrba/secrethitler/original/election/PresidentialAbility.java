package dev.vrba.secrethitler.original.election;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public enum PresidentialAbility {
    PEEK_TOP_THREE_POLICIES,
    INVESTIGATE_LOYALTY,
    CALL_SPECIAL_ELECTION,
    EXECUTE_PLAYER;

    public static @NotNull Map<Integer, PresidentialAbility> getAbilities(int players) {
        return switch (players) {
            case 5, 6 -> Map.of(
                    3, PEEK_TOP_THREE_POLICIES,
                    4, EXECUTE_PLAYER,
                    5, EXECUTE_PLAYER
            );

            case 7, 8 -> Map.of(
                    2, INVESTIGATE_LOYALTY,
                    3, CALL_SPECIAL_ELECTION,
                    4, EXECUTE_PLAYER,
                    5, EXECUTE_PLAYER
            );

            case 9, 10 -> Map.of(
                    1, INVESTIGATE_LOYALTY,
                    2, INVESTIGATE_LOYALTY,
                    3, CALL_SPECIAL_ELECTION,
                    4, EXECUTE_PLAYER,
                    5, EXECUTE_PLAYER
            );

            default -> throw new IllegalArgumentException("Number of players must be between 5 and 10 inclusive!");
        };
    }
}