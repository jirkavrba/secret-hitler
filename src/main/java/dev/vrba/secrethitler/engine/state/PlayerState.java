package dev.vrba.secrethitler.engine.state;

import dev.vrba.secrethitler.engine.Party;
import dev.vrba.secrethitler.engine.Role;
import dev.vrba.secrethitler.engine.claims.Claim;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@With
@Getter
@AllArgsConstructor
public class PlayerState {

    private final @NotNull UUID id;

    private final boolean alive;

    private final @NotNull Role role;

    private final @NotNull Map<UUID, Role> rolesKnowledge;

    private final @NotNull List<UUID> availablePlayerTargets;

    private final @NotNull List<Party> availablePolicies;

    private final @NotNull List<Claim> availableClaims;

    private final @NotNull List<Party> peekedPolicies;

    private final @Nullable Party investigatedPartyMembership;

    public @NotNull PublicPlayerState toPublicState() {
        return this.toPublicState(true);
    }

    public @NotNull PublicPlayerState toPublicState(boolean maskRole) {
        return new PublicPlayerState(
                this.id,
                this.alive,
                maskRole ? Role.HIDDEN : this.role
        );
    }
}
