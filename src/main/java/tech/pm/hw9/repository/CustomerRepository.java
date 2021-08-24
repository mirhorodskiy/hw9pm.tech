package tech.pm.hw9.repository;

import org.springframework.data.repository.CrudRepository;
import tech.pm.hw9.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  List<Customer> findAll();

  Boolean existsByEmail(String email);

  Optional<Customer> findByEmail(String email);

  Customer getCustomerByEmail(String email);

}
