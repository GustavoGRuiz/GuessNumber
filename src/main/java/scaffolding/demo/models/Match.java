package scaffolding.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Match {
    private Long id;
    private User user;
    private MatchDifficulty difficulty;
    private Integer numberToGuess;
    private Integer remainingTries;
    private MatchStatus status;
}
