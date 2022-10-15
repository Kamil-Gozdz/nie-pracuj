package pl.niepracuj.service.log;


import pl.niepracuj.model.dto.LogDto;

public interface LogService {

    void sendLog(LogDto logDto);
}
