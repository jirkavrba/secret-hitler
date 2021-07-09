package dev.vrba.secrethitler.engine.election;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Government {

    public static final UUID NOT_PRESENT = new UUID(0L, 0L);

    private final UUID president;

    private final UUID chancellor;

    public Government(@NotNull UUID president) {
        this.president = president;
        this.chancellor = NOT_PRESENT;
    }

    public @NotNull Government nominate(@NotNull UUID chancellor) {
        return new Government(this.president, chancellor);
    }
}
