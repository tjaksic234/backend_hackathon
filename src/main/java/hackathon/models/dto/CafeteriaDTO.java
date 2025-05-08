package hackathon.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeteriaDTO {
    private String cafeteriaId;
    private String name;
    private LocalDateTime workingTime;
    private String address;
    private int streetNumber;
    private String city;
}
