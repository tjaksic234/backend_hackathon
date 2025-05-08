package hackathon.models.dto;

import hackathon.models.enums.MenuType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private String cafeteriaId;
    private String name;
    private MenuType menuType;
    private LocalDate date;
    private List<String> foodIds;
}
