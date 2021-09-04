package tech.pm.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pm.hw9.model.entity.Manager;
import tech.pm.hw9.model.entity.Project;
import tech.pm.hw9.model.exception.EmployeeNotExistsException;
import tech.pm.hw9.model.exception.ManagerAlreadyExistsException;
import tech.pm.hw9.model.exception.ManagerNotExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.repository.EmployeeRepository;
import tech.pm.hw9.repository.ManagerRepository;
import tech.pm.hw9.repository.ProjectRepository;

import java.util.List;

@Service
public class ManagerService {

  ManagerRepository managerRepository;
  ProjectRepository projectRepository;
  EmployeeRepository employeeRepository;

  @Autowired
  public ManagerService(ManagerRepository managerRepository,
                        ProjectRepository projectRepository,
                        EmployeeRepository employeeRepository) {
    this.managerRepository = managerRepository;
    this.projectRepository = projectRepository;
    this.employeeRepository = employeeRepository;
  }

  public Manager addManager(Manager manager) throws ManagerAlreadyExistsException {
    if (managerRepository.existsByName(manager.getName()))
      throw new ManagerAlreadyExistsException("Manager with that name already exists");
    return managerRepository.save(manager);
  }

  public Boolean setProjectManager(String managerName, String projectName)
          throws ProjectNotExistsException, ManagerNotExistsException {
    if (!managerRepository.existsByName(managerName))
      throw new ManagerNotExistsException("Manager with that name not exists");
    if (!projectRepository.existsByProjectName(projectName))
      throw new ProjectNotExistsException("Project with that name not exists");
    Manager manager = managerRepository.findByName(managerName).get();
    Project project = projectRepository.findByProjectName(projectName).get();

    manager.getProjects().add(project);
    project.setManager(manager);

    managerRepository.save(manager);
    projectRepository.save(project);
    return true;
  }

  public Manager updateManager(Manager manager) throws ManagerNotExistsException {
    if (!managerRepository.existsByName(manager.getName()))
      throw new ManagerNotExistsException("Manager with that name does not exists");
    return managerRepository.save(manager);
  }

  public void deleteManager(String name) throws ManagerNotExistsException {
    if (!managerRepository.existsByName(name))
      throw new ManagerNotExistsException("Manager with that name does not exists");
    managerRepository.delete(managerRepository.findByName(name).get());
  }

  public List<Manager> findManagersByEmployee(String employeeEmail) throws EmployeeNotExistsException {
    if (!employeeRepository.existsByEmail(employeeEmail))
      throw new EmployeeNotExistsException("Employee with that name does not exists");
    return managerRepository.findManagersByEmployee(employeeEmail);
  }


}
