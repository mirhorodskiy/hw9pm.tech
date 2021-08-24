package tech.pm.hw9.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pm.hw9.model.entity.Employee;
import tech.pm.hw9.model.entity.Project;
import tech.pm.hw9.model.exception.CustomerNotExistsException;
import tech.pm.hw9.model.exception.EmployeeNotExistsException;
import tech.pm.hw9.model.exception.ProjectAlreadyExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
  private final ProjectService projectService;

  @Autowired
  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping("/add")
  public Project addProject(@RequestBody Project project) throws ProjectAlreadyExistsException {
    return projectService.addProject(project);
  }

  @GetMapping("/getAll")
  public List<Project> getAllProjects() {
    return projectService.getAllProjects();
  }

  @GetMapping("/getTeam")
  public List<Employee> getTeamOfProject(@RequestParam String projectName) throws ProjectNotExistsException {
    return projectService.getTeamOfProject(projectName);
  }

  @PostMapping("/update")
  public Project updateProject(@RequestBody Project project) throws ProjectNotExistsException {
    return projectService.updateProject(project);
  }

  @GetMapping("/get")
  public Project getProject(@RequestParam String projectTitle) throws ProjectNotExistsException {
    return projectService.getProject(projectTitle);
  }


  @GetMapping("/getProjectByEmployee")
  public List<Project> findProjectByEmployee(@RequestParam String employeeEmail) throws EmployeeNotExistsException {
    return projectService.findProjectByEmployee(employeeEmail);
  }

  @GetMapping("/getProjectsByCustomer")
  public List<Project> findProjectsByCustomer(@RequestParam String customerEmail) throws CustomerNotExistsException {
    return projectService.findProjectsByCustomer_Email(customerEmail);
  }
}
