package scaffolding.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scaffolding.demo.models.MatchDifficulty;
import scaffolding.demo.models.User;

@NoArgsConstructor
@Data
@Setter
public class MatchDto {
    private Long id;
    private MatchDifficulty difficulty;
    private Integer remainingTries;
}
