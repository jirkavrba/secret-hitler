package dev.vrba.secrethitler.engine;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Election {

    private final Map<UUID, Vote> votes;

    public Election(@NotNull Collection<UUID> players) {
        this.votes = players.stream().collect(
                Collectors.toMap(
                        player -> player,
                        player -> Vote.NONE
                )
        );
    }

    public @NotNull Election vote(@NotNull UUID player, @NotNull Vote vote) {
        if (!this.votes.containsKey(player)) {
            throw new IllegalArgumentException("Player is not present within the current election.");
        }

        this.votes.put(player, vote);
        return this;
    }

    public @NotNull Map<UUID, Vote> maskVotesUnlessFinished() {
        // There is no need for masking the votes if election is already finished
        if (this.isFinished())  {
            return this.votes;
        }

        // Otherwise, player should only know, whether a player has voted or not
        return this.votes.entrySet()
                .stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().mask()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public boolean isFinished() {
        return this.votes.values()
                .stream()
                .noneMatch(vote -> vote == Vote.NONE);
    }

    public boolean isSuccessful() {
        return this.votes.values()
                .stream()
                .mapToInt(Vote::getValue)
                .sum() > 0;
    }
}
