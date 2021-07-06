package dev.vrba.secrethitler.engine.claims

import dev.vrba.secrethitler.engine.PartyMembership
import java.util.*

data class PartyMembershipClaim(val player: UUID, val membership: PartyMembership)
