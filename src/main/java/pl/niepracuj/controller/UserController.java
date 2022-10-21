package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.service.user.UserService;

@CrossOrigin
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
