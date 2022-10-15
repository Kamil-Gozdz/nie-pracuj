package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.service.user.UserService;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("current")
    public UserDto getLoggedInUser(){
        return userService.getLoggedInUser();
    }

    @PostMapping("login")
    public void login(){}
}
