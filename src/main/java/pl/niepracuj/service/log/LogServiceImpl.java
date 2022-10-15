package pl.niepracuj.service.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.LogDto;
import pl.niepracuj.util.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static pl.niepracuj.util.Utils.toJson;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements  LogService{

    private final HttpClient httpClient;

    @Override
    public void sendLog(LogDto logDto) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(toJson(logDto)))
                .uri(URI.create("/logs"))
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
