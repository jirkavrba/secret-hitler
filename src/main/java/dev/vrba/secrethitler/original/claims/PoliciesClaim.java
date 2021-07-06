package dev.vrba.secrethitler.original.claims;

import dev.vrba.secrethitler.original.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PoliciesClaim implements Claim {
    private final List<Party> policies;
}
