package pl.niepracuj.exception.exceptions;



import static pl.niepracuj.exception.messages.ExceptionMessages.*;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format(USER_FOR_PROVIDED_USERNAME_NOT_FOUND.getMessage(), username));
    }
}
