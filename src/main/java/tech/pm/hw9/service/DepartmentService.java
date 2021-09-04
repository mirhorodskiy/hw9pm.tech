package tech.pm.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pm.hw9.model.entity.Department;
import tech.pm.hw9.model.exception.DepartmentAlreadyExistsException;
import tech.pm.hw9.model.exception.DepartmentNotExistsException;
import tech.pm.hw9.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

  DepartmentRepository departmentRepository;

  @Autowired
  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public Department addDepartment(Department department) throws DepartmentAlreadyExistsException {
    if (departmentRepository.existsByDepartmentName(department.getDepartmentName()))
      throw new DepartmentAlreadyExistsException("Department with that name already exists!");
    return departmentRepository.save(department);
  }

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }

  public void deleteDepartment(String departmentTitle) throws DepartmentNotExistsException {
    if (!departmentRepository.existsByDepartmentName(departmentTitle))
      throw new DepartmentNotExistsException("Department with that name does not exists");
    departmentRepository.delete(departmentRepository.findByDepartmentName(departmentTitle).get());
  }

  public Department updateDepartment(Department department) throws DepartmentNotExistsException {
    if (!departmentRepository.existsByDepartmentName(department.getDepartmentName()))
      throw new DepartmentNotExistsException("Department with that name does not exists");
    return departmentRepository.save(department);
  }
}
