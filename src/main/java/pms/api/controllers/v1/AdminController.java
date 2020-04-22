package pms.api.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pms.api.dto.DepartmentDto;
import pms.api.mappers.DepartmentMapper;
import pms.api.models.Department;
import pms.api.services.DepartmentsService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final DepartmentsService departments;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public AdminController(DepartmentsService departments, DepartmentMapper departmentMapper){
        this.departments = departments;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping("departments")
    public ResponseEntity addDepartment(@RequestBody DepartmentDto departmentDto){
        Department departmentToAdd = departmentMapper.ToDepartmentFromDto(departmentDto);
        departments.add(departmentToAdd);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("departments")
    public ResponseEntity updateDepartment(@RequestBody DepartmentDto departmentDto){
        Department departmentToUpdate = departmentMapper.ToDepartmentFromDto(departmentDto);
        departments.update(departmentToUpdate);

        return new ResponseEntity(HttpStatus.OK);
    }
}
