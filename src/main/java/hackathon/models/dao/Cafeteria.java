package hackathon.models.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "cafeterias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafeteria {

    @Id
    private String id;

    private String name;

    private LocalDateTime workingTime;

    private String address;

    private int streetNumber;

    private String city;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
