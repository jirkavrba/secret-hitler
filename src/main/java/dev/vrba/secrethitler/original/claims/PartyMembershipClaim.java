package dev.vrba.secrethitler.original.claims;

import dev.vrba.secrethitler.original.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PartyMembershipClaim implements Claim {
    private final UUID player;
    private final Party partyMembership;
}
