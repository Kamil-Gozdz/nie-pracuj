package pl.niepracuj.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {

    private LocalDateTime loggedOn;

    private String message;

    @JsonIgnore
    public static LogDto getLogDto(String message){
        return LogDto.builder()
                .loggedOn(LocalDateTime.now())
                .message(message)
                .build();
    }


}
