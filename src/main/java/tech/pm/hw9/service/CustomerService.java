package tech.pm.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pm.hw9.model.entity.Customer;
import tech.pm.hw9.model.entity.Project;
import tech.pm.hw9.model.exception.CustomerAlreadyExistException;
import tech.pm.hw9.model.exception.CustomerNotExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.repository.CustomerRepository;
import tech.pm.hw9.repository.ProjectRepository;

import java.util.List;

@Service
public class CustomerService {

  CustomerRepository customerRepository;
  ProjectRepository projectRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository, ProjectRepository projectRepository) {
    this.customerRepository = customerRepository;
    this.projectRepository = projectRepository;
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
    if (customerRepository.existsByEmail(customer.getEmail()))
      throw new CustomerAlreadyExistException("Customer with that email already exists!");
    return customerRepository.save(customer);
  }

  public void addCustomerToProject(String customerEmail, String projectTitle)
          throws CustomerNotExistsException, ProjectNotExistsException {
    if (!customerRepository.existsByEmail(customerEmail))
      throw new CustomerNotExistsException("Customer with that email does not exists!");
    if (!projectRepository.existsByProjectName(projectTitle))
      throw new ProjectNotExistsException("Project with that title does not exists!");
    Customer customer = customerRepository.findByEmail(customerEmail).get();
    Project project = projectRepository.findByProjectName(projectTitle).get();

    project.setCustomer(customer);
    customer.getProjects().add(project);

    projectRepository.save(project);
    customerRepository.save(customer);
  }

  public void deleteCustomer(String CustomerEmail) throws CustomerNotExistsException {
    if (!customerRepository.existsByEmail(CustomerEmail))
      throw new CustomerNotExistsException("Customer with that email not exists");
    customerRepository.delete(customerRepository.findByEmail(CustomerEmail).get());
  }

  public Customer getCustomerByEmail(String CustomerEmail) throws CustomerNotExistsException {
    if (!customerRepository.existsByEmail(CustomerEmail))
      throw new CustomerNotExistsException("Customer with that email not exists");
    return customerRepository.getCustomerByEmail(CustomerEmail);
  }

  public Customer updateCustomer(Customer customer) throws CustomerNotExistsException {
    if (!customerRepository.existsByEmail(customer.getEmail()))
      throw new CustomerNotExistsException("Customer does not exists");
    return customerRepository.save(customer);
  }
}
