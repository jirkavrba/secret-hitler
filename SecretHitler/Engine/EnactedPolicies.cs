using System;
using System.Collections.Generic;
using SecretHitler.Engine.Exception;

namespace SecretHitler.Engine
{
    using Policy = Party;

    /// <summary>
    /// Wrapper around enacted policies and presidential abilities that can be unlocked by enacting fascist articles.
    /// </summary>
    public class EnactedPolicies
    {
        /// <summary>
        /// Number of fascist policies enacted
        /// </summary>
        public int Fascist { get; private set; }

        /// <summary>
        /// Number of liberal policies enacted
        /// </summary>
        public int Liberal { get; private set; }

        /// <summary>
        /// Map of the presidential abilities, where key is the index of fascist policy, that unlocks this power
        /// </summary>
        public IReadOnlyDictionary<int, PresidentialAbility> Abilities { get; private set; }

        /// <summary>
        /// When 5 fascist policies are enacted a veto power is unlocked and the president / chancellor are allowed
        /// to vote for cancelling the whole legislative session (and therefore not enacting any policy)
        /// </summary>
        public bool VetoPowerUnlocked => Fascist >= 5;

        /// <summary>
        /// Default constructor creating an empty board
        /// </summary>
        /// <param name="players">Number of players playing the game</param>
        public EnactedPolicies(int players)
        {
            Fascist = 0;
            Liberal = 0;
            Abilities = BuildPresidentialAbilitiesDictionary(players);
        }

        /// <summary>
        /// Enact a policy and return updated reference to this wrapper
        /// </summary>
        /// <param name="policy">Policy that will be enacted. Either <code>Party.Liberal</code> or <code>Party.Fascist</code> are allowed.</param>
        /// <exception cref="ArgumentException">Raised, when the hidden policy value is passed</exception>
        public EnactedPolicies EnactPolicy(Policy policy)
        {
            // ReSharper disable once SwitchStatementHandlesSomeKnownEnumValuesWithDefault
            switch (policy)
            {
                case Party.Fascist:
                    Fascist++;
                    break;
                
                case Party.Liberal:
                    Liberal++;
                    break;

                default:
                    throw new ArgumentException("Invalid policy provided. Expected either liberal or fascist policy.");
            }

            return this;
            ;
        }

        /// <summary>
        /// Builds the presidential abilities map based on number of players playing the game
        /// </summary>
        /// <param name="players">Number of players that are playing the game</param>
        /// <returns>Dictionary/Map containing number of fascist policies as key, presidential ability as value</returns>
        /// <exception cref="InvalidNumberOfPlayersException">Raised, when a number outside the range expected range (5, 10) is passed</exception>
        private static IReadOnlyDictionary<int, PresidentialAbility> BuildPresidentialAbilitiesDictionary(int players)
        {
            return players switch
            {
                5 or 6 => new Dictionary<int, PresidentialAbility>
                {
                    {3, PresidentialAbility.PeekPolicies},
                    {4, PresidentialAbility.ExecutePlayer},
                    {5, PresidentialAbility.ExecutePlayer}
                },

                7 or 8 => new Dictionary<int, PresidentialAbility>
                {
                    {2, PresidentialAbility.InvestigateLoyalty},
                    {3, PresidentialAbility.CallSpecialElection},
                    {4, PresidentialAbility.ExecutePlayer},
                    {5, PresidentialAbility.ExecutePlayer}
                },

                9 or 10 => new Dictionary<int, PresidentialAbility>
                {
                    {1, PresidentialAbility.InvestigateLoyalty},
                    {2, PresidentialAbility.InvestigateLoyalty},
                    {3, PresidentialAbility.CallSpecialElection},
                    {4, PresidentialAbility.ExecutePlayer},
                    {5, PresidentialAbility.ExecutePlayer}
                },

                _ => throw new InvalidNumberOfPlayersException()
            };
        }
    }
}