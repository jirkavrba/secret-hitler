package dev.vrba.secrethitler.original.state;

import dev.vrba.secrethitler.original.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PublicPlayerState {

    private final @NotNull UUID id;

    private final @NotNull String username;

    private final boolean alive;

    private final @NotNull Role role;
}
