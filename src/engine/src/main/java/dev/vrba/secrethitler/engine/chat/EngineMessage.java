package dev.vrba.secrethitler.engine.chat;

import dev.vrba.secrethitler.engine.claims.PoliciesClaim;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class EngineMessage extends ChatMessage {

    protected EngineMessage(@NotNull String content) {
        super(Type.ENGINE, content);
    }

    public static @NotNull EngineMessage claim(@NotNull UUID player, @NotNull PoliciesClaim claim) {
        return new EngineMessage(
                String.format("%s claims %s", mention(player),
                        claim.getPolicies()
                                .stream()
                                .map(ChatMessage::claim)
                                .collect(Collectors.joining(" "))
                )
        );
    }
}
