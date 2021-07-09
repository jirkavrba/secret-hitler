namespace SecretHitler.Engine
{
    /// <summary>
    /// Special presidential abilities, unlocked by enacting fascist policies during the legislative session
    /// </summary>
    public enum PresidentialAbility
    {
        /// <summary>
        /// President looks at the top three policies in drawing deck and gains ability to claim about this
        /// </summary>
        PeekPolicies,
        
        /// <summary>
        /// President investigates loyalty (party membership) of a selected players and can claim this party membership.
        /// </summary>
        InvestigateLoyalty,
        
        /// <summary>
        /// President gains the ability to select the next president (instead of passing the candidacy to the next player)
        /// </summary>
        CallSpecialElection,
        
        /// <summary>
        /// President selects a player, which is then executed. If Hitler is executed this way, liberals win the game.
        /// </summary>
        ExecutePlayer
    }
}