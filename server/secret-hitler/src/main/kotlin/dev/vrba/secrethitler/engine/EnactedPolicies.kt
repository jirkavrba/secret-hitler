package dev.vrba.secrethitler.engine

const val requiredFascistPolicies = 6
const val requiredLiberalPolicies = 5

data class EnactedPolicies(val fascist: Int, val liberal: Int, val abilities: Map<Int, PresidentialAbility>) {

    constructor(players: Int) : this(0, 0, getPresidentialAbilities(players))

    fun enact(policy: Policy): EnactedPolicies =
        when (policy) {
            Policy.Fascist -> copy(fascist = fascist + 1)
            Policy.Liberal -> copy(liberal = liberal + 1)
            else -> throw IllegalArgumentException("Invalid policy provided. Expected either fascist or liberal policy")
        }
}
