package dev.vrba.secrethitler.engine;

import dev.vrba.secrethitler.engine.election.PresidentialAbility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@AllArgsConstructor
public class EnactedPolicies {

    private final int fascist;

    private final int liberal;

    private final Map<Integer, PresidentialAbility> abilities;

    public EnactedPolicies(int players) {
        this.fascist = 0;
        this.liberal = 0;
        this.abilities = PresidentialAbility.getAbilities(players);
    }

    public @NotNull EnactedPolicies add(@NotNull Party policy) {
        return switch (policy) {
            case LIBERAL -> new EnactedPolicies(fascist, liberal + 1, this.abilities);
            case FASCIST -> new EnactedPolicies(fascist + 1, liberal, this.abilities);

            default -> throw new IllegalArgumentException("Expected either liberal or fascist policy.");
        };
    }
}
