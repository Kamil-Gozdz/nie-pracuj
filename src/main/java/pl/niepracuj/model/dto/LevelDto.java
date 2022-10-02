package pl.niepracuj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LevelDto {
    private Long id;

    private String name;

    private Integer score;

}
