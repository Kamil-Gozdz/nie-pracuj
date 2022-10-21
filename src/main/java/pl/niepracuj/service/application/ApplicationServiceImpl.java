package pl.niepracuj.service.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.exception.exceptions.EntityNotFoundException;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.model.entity.Application;
import pl.niepracuj.model.mapper.ApplicationMapper;
import pl.niepracuj.repository.AdvertisementRepository;
import pl.niepracuj.repository.ApplicationRepository;
import pl.niepracuj.service.file.FileService;

import javax.transaction.Transactional;
import java.io.IOException;
@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository applicationRepository;

    private final AdvertisementRepository advertisementRepository;

    private final ApplicationMapper applicationMapper;

    private final FileService fileService;
    @Override
    public ApplicationDto createApplication(ApplicationCreateDto createDto) throws IOException {
        Application application = applicationMapper.toNewEntity(createDto);
        application.setPath(fileService.saveFile(createDto.getCv()));
        application.setAdvertisement(advertisementRepository.findById(createDto.getAdvertisementId())
                .orElseThrow(()->new EntityNotFoundException("Advertisement",createDto.getAdvertisementId())));
        return applicationMapper.toDto(applicationRepository.save(application));
    }

    @Override
    public void deleteApplicationById(Long id) {
        applicationRepository.deleteById(id);
    }
}
