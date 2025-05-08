package hackathon.models.dto;

import hackathon.models.enums.Allergy;
import hackathon.models.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {
    private String name;
    private Allergy[] allergies;
    private FoodType foodType;
}
