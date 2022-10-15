package pl.niepracuj.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import pl.niepracuj.model.entity.Advertisement;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationCreateDto {

    private String name;

    private String surname;

    private String email;

    private String introduction;

    private MultipartFile cv;

    private Long advertisementId;
}
