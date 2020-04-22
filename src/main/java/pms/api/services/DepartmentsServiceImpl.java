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
    public Department GetById(long id) {
        return departments.findOne(id);
    }

    @Override
    public void Add(Department department) {
        if (departments.findByName(department.getName()) != null)
            throw new EntityExistsException("Department with name " + department.getName() + " already exists");

        departments.save(department);
    }

    @Override
    public void Update(Department department) {
        if (department.getId() == null) {
            throw new IllegalArgumentException("Department with id " + department.getId() + " doesn't exists");
        }

        departments.save(department);
    }

    @Override
    public List<Department> GetAll(){
        return departments.findAll();
    }
}
