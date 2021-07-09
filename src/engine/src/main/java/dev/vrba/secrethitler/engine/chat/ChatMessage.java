package dev.vrba.secrethitler.engine.chat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ChatMessage {

    public enum Type {
        PLAYER,
        ENGINE
    }

    protected final Type type;

    protected final String content;

}
