package pl.niepracuj.model.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.model.entity.Application;

@Component
@RequiredArgsConstructor
public class ApplicationMapper {

    public ApplicationDto toDto(Application application){
        return ApplicationDto.builder()
                .id(application.getId())
                .name(application.getName())
                .surname(application.getSurname())
                .email(application.getEmail())
                .introduction(application.getIntroduction())
                .path(application.getPath())
                .build();
    }
    public Application toNewEntity(ApplicationCreateDto createDto){
        return  Application.builder()
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail())
                .introduction(createDto.getIntroduction())
                .build();
    }
}
