package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pms.api.models.Department;

@RestResource(exported = false)
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
