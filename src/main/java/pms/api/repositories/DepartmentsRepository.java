package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.Department;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
