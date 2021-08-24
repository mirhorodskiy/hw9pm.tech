package tech.pm.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pm.hw9.model.entity.Employee;
import tech.pm.hw9.model.entity.Project;
import tech.pm.hw9.model.exception.CustomerNotExistsException;
import tech.pm.hw9.model.exception.EmployeeNotExistsException;
import tech.pm.hw9.model.exception.ProjectAlreadyExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.repository.CustomerRepository;
import tech.pm.hw9.repository.EmployeeRepository;
import tech.pm.hw9.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

  ProjectRepository projectRepository;
  EmployeeRepository employeeRepository;
  CustomerRepository customerRepository;

  @Autowired
  public ProjectService(ProjectRepository projectRepository,
                        EmployeeRepository employeeRepository,
                        CustomerRepository customerRepository) {
    this.projectRepository = projectRepository;
    this.employeeRepository = employeeRepository;
    this.customerRepository = customerRepository;
  }

  public Project addProject(Project project) throws ProjectAlreadyExistsException {
    if (projectRepository.existsByProjectName(project.getProjectName()))
      throw new ProjectAlreadyExistsException("Project with that name already exists!");
    return projectRepository.save(project);
  }

  public Project updateProject(Project project) throws ProjectNotExistsException {
    if (!projectRepository.existsByProjectName(project.getProjectName()))
      throw new ProjectNotExistsException("Project with that name does not exists!");
    return projectRepository.save(project);
  }

  public Project getProject(String projectTitle) throws ProjectNotExistsException {
    if (!projectRepository.existsByProjectName(projectTitle))
      throw new ProjectNotExistsException("Project with that name does not exists!");
    return projectRepository.findByProjectName(projectTitle).get();
  }

  public List<Employee> getTeamOfProject(String projectName) throws ProjectNotExistsException {
    if (!projectRepository.existsByProjectName(projectName))
      throw new ProjectNotExistsException("Project with that name not exists");
    return projectRepository.findByProjectName(projectName).get().getTeam();
  }

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  public List<Project> findProjectByEmployee(String employeeEmail) throws EmployeeNotExistsException {
    if (!employeeRepository.existsByEmail(employeeEmail))
      throw new EmployeeNotExistsException("Employee with that name not exists");
    return projectRepository.findProjectByEmployee(employeeEmail);
  }

  public List<Project> findProjectsByCustomer_Email(String customerEmail) throws CustomerNotExistsException {
    if (!customerRepository.existsByEmail(customerEmail))
      throw new CustomerNotExistsException("Customer with that name not exists");
    return projectRepository.findProjectsByCustomer_Email(customerEmail);
  }
}
