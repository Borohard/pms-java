package pms.api.mappers;

import pms.api.dto.UserRegisterDto;
import pms.api.models.User;

public interface UserMapper {
    User ToUserFromRegisterDto(UserRegisterDto registerDto);

}
