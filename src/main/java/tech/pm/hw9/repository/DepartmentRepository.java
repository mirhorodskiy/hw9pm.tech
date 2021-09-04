package tech.pm.hw9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.pm.hw9.model.entity.Department;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
  List<Department> findAll();

  Optional<Department> findByDepartmentName(String departmentName);

  Boolean existsByDepartmentName(String departmentName);

}
