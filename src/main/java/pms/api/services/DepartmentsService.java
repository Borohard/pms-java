package pms.api.services;

import pms.api.dto.DepartmentDto;
import pms.api.models.Department;

import java.util.List;

public interface DepartmentsService {
    List<Department> GetAll();
    Department GetById(long id);
    void Add(Department department);
    void Update(Department department);
}
