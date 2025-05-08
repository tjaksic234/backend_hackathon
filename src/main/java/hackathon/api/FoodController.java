package hackathon.api;

import hackathon.models.dto.CreateFoodRequest;
import hackathon.models.dto.FoodDTO;
import hackathon.services.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping( "api/food")
public class FoodController {

    private final FoodService foodService;

    @PostMapping("create")
    public ResponseEntity<FoodDTO> createFood(@RequestBody CreateFoodRequest request) {
        log.info("Attempting to create food entry");
        return ResponseEntity.ok(foodService.createFood(request));
    }
}
