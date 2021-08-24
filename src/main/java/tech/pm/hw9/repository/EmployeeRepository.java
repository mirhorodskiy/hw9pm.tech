package tech.pm.hw9.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.pm.hw9.model.entity.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  List<Employee> findAll();

  List<Employee> findAllByDepartmentDepartmentName(String departmentName);

  Boolean existsByEmail(String email);

  Optional<Employee> findByEmail(String email);

  //список сотрудников, работающих над заданным проектом
  @Query("select distinct e \n" +
          "from Employee e join e.projectsList pl  WHERE pl.projectName =:title")
  List<Employee> findEmployeeByProject(@Param("title") String title);

  //список сотрудников, не участвующих ни в одном проекте;
  @Query("select distinct e from Employee e where e.projectsList.size = 0")
  List<Employee> findEmployeeWithoutProjects();

  //список сотрудников из заданного отдела (programming), не участвующих ни в одном проекте;
  @Query("select distinct e from Employee e join e.department d where d.departmentName =:department and e.projectsList.size = 0")
  List<Employee> findEmployeeWithoutProjectsFromDepartment(@Param("department") String department);

  //  список подчиненных для заданного руководителя (по всем проектам, которыми он руководит);
  @Query("select distinct e from Employee e join e.projectsList pl where pl.manager.name =:managerName")
  List<Employee> findEmployeeByManager(@Param("managerName") String managerName);


  // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник.
  @Query("select distinct e from Employee e join e.projectsList pr where pr in " +
          "(select distinct p from Project p join p.team em where em.email =:employeeEmail)")
  List<Employee> findEmployeesByEmployee(@Param("employeeEmail") String employeeEmail);
}
