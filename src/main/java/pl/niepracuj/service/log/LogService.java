package pl.niepracuj.service.log;


import pl.niepracuj.model.dto.LogDto;

import java.io.IOException;

public interface LogService {

    void sendLog(LogDto logDto) throws IOException, InterruptedException;
}
