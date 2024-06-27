package scaffolding.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scaffolding.demo.models.MatchDifficulty;

@NoArgsConstructor
@Getter
@Setter
public class CreateUserMatchDto {
    private MatchDifficulty difficulty;

}
