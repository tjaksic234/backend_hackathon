package hackathon.models.dao;

import hackathon.models.enums.PostType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    private String id;

    private List<String> urlList;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String contact;

    @NotBlank
    private PostType type;

    private List<String> stars = new ArrayList<>();

    private String userId;

    private boolean isPostActive = true;
}