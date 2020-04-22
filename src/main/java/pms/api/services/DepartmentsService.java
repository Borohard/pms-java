package pms.api.services;

import pms.api.dto.DepartmentDto;
import pms.api.models.Department;

import java.util.List;

public interface DepartmentsService {
    List<Department> getAll();
    Department getById(long id);
    void add(Department department);
    void update(Department department);
}
