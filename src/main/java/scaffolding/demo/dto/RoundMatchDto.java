package scaffolding.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scaffolding.demo.models.RoundMatch;

@NoArgsConstructor
@Data
@Setter
public class RoundMatchDto {
    private MatchDto matchDto;
    private String respuesta;
}
