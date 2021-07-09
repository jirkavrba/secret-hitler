namespace SecretHitler.Engine
{
    /// <summary>
    /// A enum-like class representing the role, that each player is assigned.
    /// </summary>
    public sealed class Role
    {
        /// <summary>
        /// When investigating player loyalty only party membership is revealed.
        /// </summary>
        public readonly Party PartyMembership; 
        
        private Role(Party partyMembership)
        {
            PartyMembership = partyMembership;
        }

        public static readonly Role Hitler = new(Party.Fascist);
        public static readonly Role Fascist = new(Party.Fascist);
        public static readonly Role Liberal = new(Party.Liberal);
        public static readonly Role Hidden = new(Party.Hidden);
    }
}