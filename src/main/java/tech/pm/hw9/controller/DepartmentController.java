package tech.pm.hw9.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pm.hw9.model.entity.Department;
import tech.pm.hw9.model.exception.DepartmentAlreadyExistsException;
import tech.pm.hw9.model.exception.DepartmentNotExistsException;
import tech.pm.hw9.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
  private final DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @PostMapping("/add")
  public Department addDepartment(@RequestBody Department department)
          throws DepartmentAlreadyExistsException {
    return departmentService.addDepartment(department);
  }

  @GetMapping("/getAll")
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @DeleteMapping("/delete")
  public void deleteDepartment(@RequestParam String departmentTitle) throws DepartmentNotExistsException {
    departmentService.deleteDepartment(departmentTitle);
  }

  @PostMapping("/update")
  public Department updateDepartment(@RequestBody Department department) throws DepartmentNotExistsException {
    return departmentService.updateDepartment(department);
  }


}
