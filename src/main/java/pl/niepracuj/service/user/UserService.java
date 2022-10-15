package pl.niepracuj.service.user;

import pl.niepracuj.model.dto.UserDto;

public interface UserService {

    UserDto getLoggedInUser();
}
