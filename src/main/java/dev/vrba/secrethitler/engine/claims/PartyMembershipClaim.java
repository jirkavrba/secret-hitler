package dev.vrba.secrethitler.engine.claims;

import dev.vrba.secrethitler.engine.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PartyMembershipClaim {
    private final UUID player;
    private final Party partyMembership;
}
