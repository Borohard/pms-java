package pms.api.mappers;

import org.springframework.stereotype.Service;
import pms.api.dto.UserRegisterDto;
import pms.api.models.User;
import pms.api.services.DepartmentsService;

@Service
public class UserMapperImpl implements UserMapper {
    private final DepartmentsService departments;

    public UserMapperImpl(DepartmentsService departments) {
        this.departments = departments;
    }

    @Override
    public User ToUserFromRegisterDto(UserRegisterDto registerDto) {
        User res = new User();

        res.setLogin(registerDto.getUsername());
        res.setPassword(registerDto.getPassword());
        res.setFullName(registerDto.getFullName());
        res.setDepartment(departments.getById(registerDto.getDepartmentId()));

        return res;
    }
}
