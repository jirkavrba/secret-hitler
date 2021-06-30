package dev.vrba.secrethitler.engine.claims;

import dev.vrba.secrethitler.engine.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PoliciesClaim implements Claim {
    private final List<Party> policies;
}
