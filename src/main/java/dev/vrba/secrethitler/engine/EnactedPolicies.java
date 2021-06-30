package dev.vrba.secrethitler.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class EnactedPolicies {

    private final int fascist;

    private final int liberal;

    public EnactedPolicies() {
        this.fascist = 0;
        this.liberal = 0;
    }

    public @NotNull EnactedPolicies add(@NotNull Party policy) {
        return switch (policy) {
            case LIBERAL -> new EnactedPolicies(fascist, liberal + 1);
            case FASCIST -> new EnactedPolicies(fascist + 1, liberal);

            default -> throw new IllegalArgumentException("Expected either liberal or fascist policy.");
        };
    }
}
