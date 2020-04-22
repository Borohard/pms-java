package pms.api.mappers;

import pms.api.dto.DepartmentDto;
import pms.api.models.Department;

public interface DepartmentMapper {
    DepartmentDto ToDtoFromDepartment(Department department);
    Department ToDepartmentFromDto(DepartmentDto departmentDto);
}
