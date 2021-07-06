package dev.vrba.secrethitler.engine.state

import dev.vrba.secrethitler.engine.PartyMembership
import dev.vrba.secrethitler.engine.Policy
import dev.vrba.secrethitler.engine.Role
import dev.vrba.secrethitler.engine.claims.PartyMembershipClaim
import dev.vrba.secrethitler.engine.claims.PoliciesClaim
import java.util.*

/**
 * State that can be broadcasted to everybody without revealing personal knowledge (what is kept secret)
 */
data class PublicPlayerState(
    val id: UUID,
    val username: String,
    val alive: Boolean,
    val role: Role
)

data class PlayerState(
    val id: UUID,
    val username: String,
    val alive: Boolean,
    val role: Role,
    val rolesKnowledge: Map<UUID, Role> = emptyMap(),
    val availablePlayerTargets: List<UUID> = emptyList(),
    val availablePolicies: List<Policy> = emptyList(),
    val availablePoliciesClaims: List<PoliciesClaim> = emptyList(),
    val availablePartyMembershipClaims: List<PartyMembershipClaim> = emptyList(),
    val investigatedMemberships: Map<UUID, PartyMembership> = emptyMap(),
    val peekedPolicies: List<Policy> = emptyList()
) {
    fun public(maskRoles: Boolean = true): PublicPlayerState =
        PublicPlayerState(
            id,
            username,
            alive,
            if (maskRoles) Role.Hidden else role
        )
}