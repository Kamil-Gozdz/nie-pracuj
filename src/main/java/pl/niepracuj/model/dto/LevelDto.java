package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelDto {

    private Long id;

    private String name;

    private Integer score;

}
