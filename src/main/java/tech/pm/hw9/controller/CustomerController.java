package tech.pm.hw9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pm.hw9.model.entity.Customer;
import tech.pm.hw9.model.exception.CustomerAlreadyExistException;
import tech.pm.hw9.model.exception.CustomerNotExistsException;
import tech.pm.hw9.model.exception.ProjectNotExistsException;
import tech.pm.hw9.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/getAll")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @PostMapping("/add")
  public Customer addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistException {
    return customerService.addCustomer(customer);
  }

  @DeleteMapping("/delete")
  public void deleteCustomer(@RequestParam String customerEmail) throws CustomerNotExistsException {
    customerService.deleteCustomer(customerEmail);
  }

  @GetMapping("/get")
  public Customer getCustomerByEmail(@RequestParam String customerEmail) throws CustomerNotExistsException {
    return customerService.getCustomerByEmail(customerEmail);
  }

  @GetMapping("/assignToProject")
  public void assignCustomerToProject(@RequestParam String customerEmail, @RequestParam String projectTitle)
          throws CustomerNotExistsException, ProjectNotExistsException {
    customerService.addCustomerToProject(customerEmail, projectTitle);
  }

  @PostMapping("/update")
  public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotExistsException {
    return customerService.updateCustomer(customer);
  }
}
