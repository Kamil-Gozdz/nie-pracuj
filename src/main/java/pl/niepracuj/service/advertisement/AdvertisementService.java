package pl.niepracuj.service.advertisement;

import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> getAllAdvertisements();

    AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto);
}
