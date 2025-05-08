package hackathon.models.dto;

import hackathon.models.enums.MenuType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequest {
    private String name;
    private MenuType menuType;
    private LocalDate date;
    private String[] foodIds;
}
