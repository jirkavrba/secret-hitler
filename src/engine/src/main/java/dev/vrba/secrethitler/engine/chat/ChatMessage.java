package dev.vrba.secrethitler.engine.chat;

import dev.vrba.secrethitler.engine.Party;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ChatMessage {

    public enum Type {
        PLAYER,
        ENGINE
    }

    protected final Type type;

    protected final String content;

    public static @NotNull String mention(@NotNull UUID player) {
        return String.format("@player[%s]", player);
    }

    public static @NotNull String claim(@NotNull Party party) {
        return String.format("@claim[%s]", party.toString().toLowerCase(Locale.ROOT));
    }
}
