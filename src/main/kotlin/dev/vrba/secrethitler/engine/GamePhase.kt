package dev.vrba.secrethitler.engine

enum class GamePhase {
    PresidentIsNominatingChancellor,

    VotingForTheGovernment,

    PresidentIsSelectingPolicy,
    ChancellorIsSelectingPolicy,

    PresidentIsApprovingVeto,

    PresidentIsSeekingPolicies,
    PresidentIsSelectingPlayerForLoyaltyInvestigation,
    PresidentIsSelectingPlayerForExecution,
    PresidentIsNominatingTheNextPresident,

    GameEnded
}