package dev.vrba.secrethitler.engine.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Chat {

    private final List<ChatMessage> messages = new ArrayList<>();

    public void send(@NotNull ChatMessage message) {
        // TODO: Implement observer pattern / hooks
        this.messages.add(message);
    }
}
