package scaffolding.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

@Entity
@Data
@Getter
@Setter
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="user_name", nullable = false)
    private String userName;
    @Column(name = "email", nullable = false)
    private String email;

}
