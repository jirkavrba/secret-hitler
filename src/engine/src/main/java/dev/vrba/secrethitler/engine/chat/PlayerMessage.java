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
}
