package pl.niepracuj.service.advertisement;

import org.springframework.data.domain.Pageable;
import pl.niepracuj.model.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.advertisement.AdvertisementDto;
import pl.niepracuj.model.advertisement.AdvertisementSearchCriteriaDto;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> getAllAdvertisements();
    List<AdvertisementDto> getAdvertisementsForCompany(Long companyId);

    List<AdvertisementDto> getAdvertisementsByCriteria(AdvertisementSearchCriteriaDto criteriaDto, Pageable pageable);

    AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto);


}
