package scaffolding.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import scaffolding.demo.models.MatchDifficulty;
import scaffolding.demo.models.MatchStatus;
import scaffolding.demo.models.User;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@Table(name="matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name="user_id") //Hacemos la relación de la FK
    @ManyToOne//Para contemplar la relación uno a muchos entre un jugador y varias partidas
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)//Para que impacte como un string en la BD al momento de guardar
    private MatchDifficulty difficulty;

    private Integer numberToGuess;

    private Integer remainingTries;

    @Enumerated(EnumType.STRING)//Para que impacte como un string en la BD al momento de guardar
    private MatchStatus status;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updateDate;
}
