package tech.pm.hw9.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.pm.hw9.model.entity.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
  List<Project> findAll();

  Optional<Project> findByProjectName(String projectName);

  Boolean existsByProjectName(String projectName);

  // список проектов, в которых участвует заданный сотрудник;
  @Query("select distinct p from Project p join p.team t where t.email =:employeeEmail")
  List<Project> findProjectByEmployee(@Param("employeeEmail") String employeeEmail);

  // список проектов, выполняемых для заданного заказчика
  @Query("select distinct p from Project p join p.customer c where c.email =:customerEmail")
  List<Project> findProjectsByCustomer_Email(@Param("customerEmail") String customerEmail);
}
