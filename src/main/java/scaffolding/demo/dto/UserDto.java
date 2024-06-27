package scaffolding.demo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Data; //Generación automática de getters y setters de las properties
import lombok.NoArgsConstructor; //Constructor sin parámetros
import lombok.Setter;

@NoArgsConstructor //Crear constructores sin argumentos
@Data //Para getters y Setters
@Setter
public class UserDto {

    private Long id;
    @JsonProperty("username") //Para que coordine con el nombre de la tabla de la H2
    private String userName;
    @Email
    private String email;
}
