package scaffolding.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
public class RoundMatch {
    private Match matchId;
    private String respuesta;
}
