package pl.niepracuj.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import pl.niepracuj.model.advertisement.AdvertisementDto;
import pl.niepracuj.model.entity.Advertisement;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String introduction;

    private String path;

    private AdvertisementDto advertisement;
}
