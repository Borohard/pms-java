package pms.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.api.models.Department;
import pms.api.repositories.DepartmentsRepository;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentsRepository departments;

    public List<Department> GetAll(){
        return departments.findAll();
    }
}
