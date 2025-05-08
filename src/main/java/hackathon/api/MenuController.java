package hackathon.api;

import hackathon.models.dto.CreateMenuRequest;
import hackathon.models.dto.MenuDTO;
import hackathon.services.MenuService;
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
@RequestMapping( "api/menus")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("create")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody CreateMenuRequest request) {
        log.info("Attempting to create a menu");
        return ResponseEntity.ok(menuService.createMenu(request));
    }

}
