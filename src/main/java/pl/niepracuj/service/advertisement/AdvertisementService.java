package pl.niepracuj.service.advertisement;

import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> getAllAdvertisements();

    List<AdvertisementDto> getAdvertisementsByCriteria(AdvertisementSearchCriteriaDto criteriaDto);

    AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto);
}
