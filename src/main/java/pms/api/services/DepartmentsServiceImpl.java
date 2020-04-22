package pms.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.api.models.Department;
import pms.api.repositories.DepartmentsRepository;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    private final DepartmentsRepository departments;

    public DepartmentsServiceImpl(DepartmentsRepository departments) {
        this.departments = departments;
    }

    @Override
    public Department getById(long id) {
        return departments.findOne(id);
    }

    @Override
    public void add(Department department) {
        if (departments.findByName(department.getName()) != null)
            throw new EntityExistsException("Department with name " + department.getName() + " already exists");

        departments.save(department);
    }

    @Override
    public void update(Department department) {
        if (department.getId() == null) {
            throw new IllegalArgumentException("Department with id " + department.getId() + " doesn't exists");
        }

        departments.save(department);
    }

    @Override
    public List<Department> getAll(){
        return departments.findAll();
    }
}
