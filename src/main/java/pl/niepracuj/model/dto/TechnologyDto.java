package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {

    private Long id;

    private TechnologyEnum name;
}
