package tech.pm.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pm.hw9.model.entity.Department;
import tech.pm.hw9.model.entity.Employee;
import tech.pm.hw9.model.entity.Project;
import tech.pm.hw9.model.exception.*;
import tech.pm.hw9.repository.DepartmentRepository;
import tech.pm.hw9.repository.EmployeeRepository;
import tech.pm.hw9.repository.ManagerRepository;
import tech.pm.hw9.repository.ProjectRepository;

import java.util.List;

@Service
public class EmployeeService {

  EmployeeRepository employeeRepository;
  ProjectRepository projectRepository;
  DepartmentRepository departmentRepository;
  ManagerRepository managerRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository,
                         ProjectRepository projectRepository,
                         DepartmentRepository departmentRepository,
                         ManagerRepository managerRepository) {
    this.employeeRepository = employeeRepository;
    this.projectRepository = projectRepository;
    this.departmentRepository = departmentRepository;
    this.managerRepository = managerRepository;
  }

  public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
    if (employeeRepository.existsByEmail(employee.getEmail()))
      throw new EmployeeAlreadyExistsException("Employee with that email already exists!");
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(String email) throws EmployeeNotExistsException {
    if (!employeeRepository.existsByEmail(email))
      throw new EmployeeNotExistsException("Employee with that email not exists");
    employeeRepository.delete(employeeRepository.findByEmail(email).get());
  }

  public void addEmployeeToTeam(String email, String projectName)
          throws EmployeeAlreadyExistsException, ProjectNotExistsException {
    if (!employeeRepository.existsByEmail(email))
      throw new EmployeeAlreadyExistsException("Employee with that email not exists");
    if (!projectRepository.existsByProjectName(projectName))
      throw new ProjectNotExistsException("Project with that name not exists");
    Employee employee = employeeRepository.findByEmail(email).get();
    Project project = projectRepository.findByProjectName(projectName).get();

    project.getTeam().add(employee);
    employee.getProjectsList().add(project);

    employeeRepository.save(employee);
    projectRepository.save(project);
  }

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public List<Employee> getAllEmployeesByDepartment(String departmentName) throws DepartmentNotExistsException {
    if (!departmentRepository.existsByDepartmentName(departmentName))
      throw new DepartmentNotExistsException("Department with that name not exists");
    return employeeRepository.findAllByDepartmentDepartmentName(departmentName);
  }

  public void assignEmployeeToDepartmentByEmailAddress(String email, String departmentName)
          throws EmployeeNotExistsException, DepartmentNotExistsException {
    if (!employeeRepository.existsByEmail(email)) {
      throw new EmployeeNotExistsException("Employee with that email not exists");
    }
    if (!departmentRepository.existsByDepartmentName(departmentName))
      throw new DepartmentNotExistsException("Department with that name not exists");

    Employee employee = employeeRepository.findByEmail(email).get();
    Department department = departmentRepository.findByDepartmentName(departmentName).get();

    employee.setDepartment(department);
    department.getEmployeeList().add(employee);

    employeeRepository.save(employee);
    departmentRepository.save(department);
  }

  public Employee updateEmployee(Employee employee) throws EmployeeNotExistsException {
    if (!employeeRepository.existsByEmail(employee.getEmail()))
      throw new EmployeeNotExistsException("Employee does no exists");
    return employeeRepository.save(employee);
  }

  public List<Employee> findEmployeeByProject(String projectTitle) throws ProjectNotExistsException {
    if (!projectRepository.existsByProjectName(projectTitle))
      throw new ProjectNotExistsException("Project with that name not exists");
    return employeeRepository.findEmployeeByProject(projectTitle);
  }

  public List<Employee> findEmployeeWithoutProjects() {
    return employeeRepository.findEmployeeWithoutProjects();
  }

  public List<Employee> findEmployeeWithoutProjectsFromDepartment(String departmentName) throws DepartmentNotExistsException {
    if (!departmentRepository.existsByDepartmentName(departmentName))
      throw new DepartmentNotExistsException("Department with that name not exists");
    return employeeRepository.findEmployeeWithoutProjectsFromDepartment(departmentName);
  }

  public List<Employee> findEmployeeByManager(String managerName) throws ManagerNotExistsException {
    if (!managerRepository.existsByName(managerName))
      throw new ManagerNotExistsException("Manager with that name not exists");
    return employeeRepository.findEmployeeByManager(managerName);
  }

  public List<Employee> findEmployeesByEmployee(String employeeEmail) throws EmployeeNotExistsException {
    if (!employeeRepository.existsByEmail(employeeEmail))
      throw new EmployeeNotExistsException("Employee with that name not exist");
    return employeeRepository.findEmployeesByEmployee(employeeEmail);
  }

}
