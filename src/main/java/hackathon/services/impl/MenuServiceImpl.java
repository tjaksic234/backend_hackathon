package hackathon.services.impl;

import hackathon.converters.ConverterService;
import hackathon.exceptions.NotFoundException;
import hackathon.models.dao.Menu;
import hackathon.models.dto.CreateMenuRequest;
import hackathon.models.dto.MenuDTO;
import hackathon.repository.FoodRepository;
import hackathon.repository.MenuRepository;
import hackathon.services.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final FoodRepository foodRepository;

    private final ConverterService converterService;

    @Override
    public MenuDTO createMenu(CreateMenuRequest request) {
        List<String> validFoodIds = Arrays.stream(request.getFoodIds())
                .filter(id -> foodRepository.findFoodById(id) != null)
                .toList();

        if (validFoodIds.isEmpty()) {
            throw new NotFoundException("There are no valid food ids in request");
        }

        Menu menu = new Menu();
        menu.setName(request.getName());
        menu.setMenuType(request.getMenuType());
        menu.setDate(request.getDate());
        menu.setFoodIds(validFoodIds);

        menuRepository.save(menu);

        log.info("Successfully created a menu");
        return converterService.convertMenuToMenuDTO(menu);
    }
}
