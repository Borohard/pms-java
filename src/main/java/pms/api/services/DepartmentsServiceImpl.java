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
        List<Department> response = departments.findAll();

        //Исправить на изначально ленивую загрузку, ибо возникает self-reference loop
        response.forEach(department -> {
            department.users = null;
            department.responsibleUser = null;
        });

        return response;
    }
}
