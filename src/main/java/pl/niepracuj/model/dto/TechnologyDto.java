package pl.niepracuj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.niepracuj.model.enums.TechnologyEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TechnologyDto {
    private Long id;

    private TechnologyEnum name;
}
