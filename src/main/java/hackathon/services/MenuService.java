package hackathon.services;

import hackathon.models.dto.CreateMenuRequest;
import hackathon.models.dto.MenuDTO;

public interface MenuService {
    MenuDTO createMenu(CreateMenuRequest request);
}
