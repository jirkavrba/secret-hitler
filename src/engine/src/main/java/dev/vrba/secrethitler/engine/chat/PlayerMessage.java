package dev.vrba.secrethitler.engine.chat;

import dev.vrba.secrethitler.engine.Party;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

@Getter
public class PlayerMessage extends ChatMessage {

    private final UUID sender;

    public PlayerMessage(@NotNull UUID sender, @NotNull String content) {
        super(Type.PLAYER, content);
        this.sender = sender;
    }

    public static @NotNull String mention(@NotNull UUID player) {
        return String.format("@player[%s]", player);
    }

    public static @NotNull String claim(@NotNull Party party) {
        return String.format("@claim[%s]", party.toString().toLowerCase(Locale.ROOT));
    }
}
