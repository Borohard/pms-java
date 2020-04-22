package pms.api.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.api.dto.DepartmentDto;
import pms.api.models.Department;
import pms.api.models.User;
import pms.api.services.UserService;

@Service
public class DepartmentMapperImpl implements DepartmentMapper {
    private final UserService users;

    public DepartmentMapperImpl(UserService users) {
        this.users = users;
    }

    @Override
    public DepartmentDto ToDtoFromDepartment(Department department){
        DepartmentDto res = new DepartmentDto();
        res.setId(department.getId());
        res.setName(department.getName());
        res.setResponsibleUserId(department.getResponsibleUser() != null ?
                department.getResponsibleUser().getId() : null);

        return res;
    }

    @Override
    public Department ToDepartmentFromDto(DepartmentDto departmentDto) {
        Department res = new Department();
        if (departmentDto.getId() != null)
            res.setId(departmentDto.getId());
        res.setName(departmentDto.getName());

        if(departmentDto.getResponsibleUserId() != null)
            res.setResponsibleUser(users.findById(departmentDto.getResponsibleUserId()));

        return res;
    }
}
