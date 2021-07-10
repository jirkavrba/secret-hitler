package dev.vrba.secrethitler.engine

enum class Role(val partyMembership: Party) {
    Hitler(Party.Fascist),
    Fascist(Party.Fascist),
    Liberal(Party.Liberal),
    Hidden(Party.Hidden)
}