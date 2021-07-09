using System;

namespace SecretHitler.Engine.Exception
{
    public class InvalidNumberOfPlayersException : ArgumentException
    {
        public InvalidNumberOfPlayersException() : base("Invalid number of players provided. Expected a number between 5 and 10 inclusive.")
        {
            
        }
    }
}