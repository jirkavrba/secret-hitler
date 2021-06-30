package dev.vrba.secrethitler.engine.state;

import dev.vrba.secrethitler.engine.EnactedPolicies;
import dev.vrba.secrethitler.engine.Party;
import dev.vrba.secrethitler.engine.Phase;
import dev.vrba.secrethitler.engine.election.Election;
import dev.vrba.secrethitler.engine.election.Government;
import dev.vrba.secrethitler.engine.election.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PublicGameState {
    private final boolean playing;

    private final @NotNull Phase phase;

    private final @NotNull Map<UUID, PublicPlayerState> players;

    private final @NotNull EnactedPolicies enactedPolicies;

    private final int drawingDeckCards;

    private final int discardingDeckCards;

    private final @NotNull Government government;

    private final @Nullable Government lastElectedGovernment;

    private final @Nullable Map<UUID, Vote> election;

    private final @Nullable Party winners;
}
