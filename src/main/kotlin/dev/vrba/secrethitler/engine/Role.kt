package dev.vrba.secrethitler.engine

enum class Role(val partyMembership: PartyMembership) {
    Hitler(Party.Fascist),
    Fascist(Party.Fascist),
    Liberal(Party.Liberal),
    Hidden(Party.Hidden)
}