using System.Collections;
using System.Collections.Generic;
using System.Linq;
using SecretHitler.Engine.Exception;

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

        /// <summary>
        /// Creates a role pool for specified number of players
        /// </summary>
        /// <param name="players">Number of players playing the game</param>
        /// <returns>Created role pool</returns>
        /// <exception cref="InvalidNumberOfPlayersException">Raised, when number of players is outside the range (5, 10)</exception>
        public static IEnumerable CreateRolePool(int players)
        {
            return players switch
            {
                5 => CreateRolePool(1, 3),
                6 => CreateRolePool(1, 4),
                7 => CreateRolePool(2, 4),
                8 => CreateRolePool(2, 5),
                9 => CreateRolePool(3, 5),
                10 => CreateRolePool(3, 6),
                _ => throw new InvalidNumberOfPlayersException()
            };
        }

        /// <summary>
        /// Creates a role pool with specified number of roles + Hitler
        /// </summary>
        /// <param name="fascists">Number of fascists (without Hitler)</param>
        /// <param name="liberals">Number of liberals</param>
        /// <returns></returns>
        private static IEnumerable CreateRolePool(int fascists, int liberals) =>
            new List<Role> {Hitler}
                .Concat(Enumerable.Repeat(Fascist, fascists))
                .Concat(Enumerable.Repeat(Liberal, liberals));
    }
}