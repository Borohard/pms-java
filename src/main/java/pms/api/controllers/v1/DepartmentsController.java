package pms.api.controllers.v1;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pms.api.dto.DepartmentDto;
import pms.api.mappers.DepartmentMapper;
import pms.api.models.Department;
import pms.api.services.DepartmentsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RepositoryRestController
@RequestMapping("/api/v1/departments")
public class DepartmentsController {
    private final DepartmentsService departments;
    private final DepartmentMapper mapper;

    public DepartmentsController(DepartmentsService departments, DepartmentMapper mapper) {
        this.departments = departments;
        this.mapper = mapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAll() {
        List<Department> dbDepartments = departments.GetAll();
        if (dbDepartments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<DepartmentDto> response = new ArrayList<>();
        dbDepartments.forEach(department -> {
            response.add(mapper.ToDtoFromDepartment(department));
        });

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
