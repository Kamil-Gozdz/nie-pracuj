package pl.niepracuj.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.model.entity.User;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class UserMapper {

    CompanyMapper companyMapper;


    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .companyId(getCompany(user))
                .build();
    }

    public User toNewEntity (UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .build();
    }

    private Long getCompany(User user){
        if(nonNull(user.getCompany())){
            return user.getCompany().getId();
        }else{
            return null;
        }
    }
}
