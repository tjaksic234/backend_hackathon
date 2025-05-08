package hackathon.services.impl;

import hackathon.converters.ConverterService;
import hackathon.models.dao.Cafeteria;
import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;
import hackathon.repository.CafeteriaRepository;
import hackathon.services.CafeteriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CafeteriaServiceImpl implements CafeteriaService {

    private final CafeteriaRepository cafeteriaRepository;

    private final ConverterService converterService;

    @Override
    public CafeteriaDTO createCafeteria(CreateCafeteriaRequest request) {

        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setName(request.getName());
        cafeteria.setWorkingTime(request.getWorkingTime());
        cafeteria.setAddress(request.getAddress());
        cafeteria.setStreetNumber(request.getStreetNumber());
        cafeteria.setCity(request.getCity());

        cafeteriaRepository.save(cafeteria);

        log.info("Successfully created a cafeteria");
        return converterService.convertCafeteriaToCafeteriaDTO(cafeteria);
    }
}
