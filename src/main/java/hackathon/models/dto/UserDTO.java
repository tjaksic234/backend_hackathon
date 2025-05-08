package hackathon.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hackathon.models.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private List<RoleType> roles;
}
