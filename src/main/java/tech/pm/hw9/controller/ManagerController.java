package tech.pm.hw9.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pm.hw9.model.entity.Manager;
import tech.pm.hw9.model.exception.EmployeeNotExistsException;
import tech.pm.hw9.model.exception.ManagerAlreadyExistsException;
import tech.pm.hw9.model.exception.ManagerNotExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
  private final ManagerService managerService;

  @Autowired
  public ManagerController(ManagerService managerService) {
    this.managerService = managerService;
  }

  @PostMapping("/add")
  public Manager addManager(@RequestBody Manager manager) throws ManagerAlreadyExistsException {
    return managerService.addManager(manager);
  }

  @PostMapping("/assign")
  public Boolean assignManagerToProject(@RequestParam String managerName, @RequestParam String projectName)
          throws ManagerNotExistsException, ProjectNotExistsException {
    return managerService.setProjectManager(managerName, projectName);
  }

  @PostMapping("/update")
  public Manager updateManager(@RequestBody Manager manager) throws ManagerNotExistsException {
    return managerService.updateManager(manager);
  }

  @DeleteMapping("/delete")
  public void deleteManager(@RequestParam String managerName) throws ManagerNotExistsException {
    managerService.deleteManager(managerName);
  }

  @GetMapping("/findManagersByEmployee")
  public List<Manager> findManagersByEmployee(@RequestParam String employeeEmail) throws EmployeeNotExistsException {
    return managerService.findManagersByEmployee(employeeEmail);
  }
}
