package dev.vrba.secrethitler.engine

import dev.vrba.secrethitler.original.election.PresidentialAbility
import org.jetbrains.annotations.Contract

const val requiredFascistPolicies = 6
const val requiredLiberalPolicies = 5

data class EnactedPolicies(val fascist: Int, val liberal: Int, val abilities: Map<Int, PresidentialAbility>) {

    constructor(players: Int) : this(0, 0, PresidentialAbility.getAbilities(players))

    @Contract(pure = true)
    fun addPolicy(policy: Policy): EnactedPolicies =
        when (policy) {
            Policy.Fascist -> EnactedPolicies(fascist + 1, liberal, abilities)
            Policy.Liberal -> EnactedPolicies(fascist, liberal + 1, abilities)
            else -> throw IllegalArgumentException("Expected either liberal or fascist policy.")
        }
}