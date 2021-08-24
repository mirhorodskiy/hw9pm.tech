package tech.pm.hw9.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pm.hw9.model.entity.Employee;
import tech.pm.hw9.model.exception.*;
import tech.pm.hw9.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private final EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping("/add")
  public Employee addEmployee(@RequestBody Employee employee)
          throws EmployeeAlreadyExistsException {
    return employeeService.addEmployee(employee);
  }

  @PostMapping("/assign")
  public void assignEmployeeToDepartment(@RequestParam String email, @RequestParam String departmentName)
          throws EmployeeNotExistsException, DepartmentNotExistsException {
    employeeService.assignEmployeeToDepartmentByEmailAddress(email, departmentName);
  }

  @PostMapping("/addToTeam")
  public void addEmployeeToTeam(@RequestParam String email, @RequestParam String projectName)
          throws EmployeeAlreadyExistsException, ProjectNotExistsException {
    employeeService.addEmployeeToTeam(email, projectName);
  }

  @GetMapping("/getAll")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @DeleteMapping("/delete")
  public void deleteEmployee(@RequestParam String email) throws EmployeeNotExistsException {
    employeeService.deleteEmployee(email);
  }

  @PostMapping("/update")
  public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeNotExistsException {
    return employeeService.updateEmployee(employee);
  }

  @GetMapping("/getEmployeeByProject")
  public List<Employee> findEmployeeByProject(@RequestParam String projectTitle) throws ProjectNotExistsException {
    return employeeService.findEmployeeByProject(projectTitle);
  }

  @GetMapping("/getEmployeeWithoutProjects")
  public List<Employee> findEmployeeWithoutProjects() {
    return employeeService.findEmployeeWithoutProjects();
  }

  @GetMapping("/getEmployeeWithoutProjectsFromDepartment")
  public List<Employee> findEmployeeWithoutProjectsFromDepartment(@RequestParam String departmentTitle) throws DepartmentNotExistsException {
    return employeeService.findEmployeeWithoutProjectsFromDepartment(departmentTitle);
  }

  @GetMapping("/getEmployeeByManager")
  public List<Employee> findEmployeeByManager(@RequestParam String managerName) throws ManagerNotExistsException {
    return employeeService.findEmployeeByManager(managerName);
  }

  @GetMapping("/getEmployeesByEmployee")
  List<Employee> findEmployeesByEmployee(@RequestParam String employeeEmail) throws EmployeeNotExistsException {
    return employeeService.findEmployeesByEmployee(employeeEmail);
  }

  @GetMapping("/getStaff")
  public List<Employee> getEmployeesByDepartment(@RequestParam String departmentName)
          throws DepartmentNotExistsException {
    return employeeService.getAllEmployeesByDepartment(departmentName);
  }
}
