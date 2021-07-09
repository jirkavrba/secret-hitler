package dev.vrba.secrethitler.engine.chat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ChatMessage {

    protected final String content;

}
