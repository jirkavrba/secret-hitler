package dev.vrba.secrethitler.engine

fun createRolePool(players: Int): List<Role> =
    when (players) {
        5 -> createRolePool(1, 3)
        6 -> createRolePool(1, 4)
        7 -> createRolePool(2, 4)
        8 -> createRolePool(2, 5)
        9 -> createRolePool(3, 5)
        10 -> createRolePool(3, 6)
        else -> throw IllegalArgumentException("Number of players must be between 5 and 10 inclusive")
    }

private fun createRolePool(fascists: Int, liberals: Int): List<Role> =
    List(1) { Role.Hitler } +
    List(fascists) { Role.Fascist } +
    List(liberals) { Role.Liberal }

enum class Role(val partyMembership: PartyMembership) {
    Hitler(Party.Fascist),
    Fascist(Party.Fascist),
    Liberal(Party.Liberal),
    Hidden(Party.Hidden)
}