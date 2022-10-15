package pl.niepracuj.service.application;

import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;

import java.io.IOException;

public interface ApplicationService {

    ApplicationDto createApplication(ApplicationCreateDto createDto) throws IOException;
}
