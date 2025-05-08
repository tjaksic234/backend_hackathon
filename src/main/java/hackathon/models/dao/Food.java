package hackathon.models.dao;

import hackathon.models.enums.Allergy;
import hackathon.models.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "food")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    private String id;

    private String name;

    private Allergy[] allergies;

    private FoodType foodType;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
