package hackathon.api;

import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;
import hackathon.models.dto.MenuDTO;
import hackathon.services.CafeteriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("all")
    public ResponseEntity<List<CafeteriaDTO>> getAllCafeterias() {
        log.info("Attempting to get all cafeterias");
        return ResponseEntity.ok(cafeteriaService.getAllCafeterias());
    }

    @GetMapping("{cafeteriaId}/menus")
    public ResponseEntity<List<MenuDTO>> getMenusForCafeteria(@PathVariable String cafeteriaId) {
        log.info("Attempting to get all menus for cafeteria");
        return ResponseEntity.ok(cafeteriaService.getMenusForCafeteria(cafeteriaId));
    }
}
