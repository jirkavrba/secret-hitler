package dev.vrba.secrethitler.engine

fun getPresidentialAbilities(players: Int): Map<Int, PresidentialAbility> =
    when (players) {
        5, 6 -> mapOf(
            3 to PresidentialAbility.PeekPolicies,
            4 to PresidentialAbility.ExecutePlayer,
            5 to PresidentialAbility.ExecutePlayer,
        )

        7, 8 -> mapOf(
            2 to PresidentialAbility.InvestigatePlayerLoyalty,
            3 to PresidentialAbility.CallSpecialElection,
            4 to PresidentialAbility.ExecutePlayer,
            5 to PresidentialAbility.ExecutePlayer,
        )

        9, 10 -> mapOf(
            1 to PresidentialAbility.InvestigatePlayerLoyalty,
            2 to PresidentialAbility.InvestigatePlayerLoyalty,
            3 to PresidentialAbility.CallSpecialElection,
            4 to PresidentialAbility.ExecutePlayer,
            5 to PresidentialAbility.ExecutePlayer,
        )

        else -> throw IllegalArgumentException("Number of players must be between 5 and 10 inclusive.")
    }

enum class PresidentialAbility {
    PeekPolicies,
    InvestigatePlayerLoyalty,
    CallSpecialElection,
    ExecutePlayer
}