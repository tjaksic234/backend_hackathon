package hackathon.api;

import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;
import hackathon.services.CafeteriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hackathon.security.utils.Constants.API_ROUTE;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(API_ROUTE + "/cafeterias")
public class CafeteriaController {

    private final CafeteriaService cafeteriaService;

    @PostMapping("create")
    public ResponseEntity<CafeteriaDTO> createCafeteria(@RequestBody CreateCafeteriaRequest request) {
        log.info("Attempting to create a cafeteria");
        return ResponseEntity.ok(cafeteriaService.createCafeteria(request));
    }
}
