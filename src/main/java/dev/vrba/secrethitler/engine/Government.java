package dev.vrba.secrethitler.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@With
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
}
