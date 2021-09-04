package tech.pm.hw9.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.pm.hw9.model.entity.Manager;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
  Boolean existsByName(String name);

  Optional<Manager> findByName(String name);

  // список руководителей для заданного сотрудника (Koropie) (по всем проектам, в которых он участвует);
  @Query("select distinct m from Manager m join Project p where p in " +
          "(select distinct p from Project p join p.team t where t.email =:employeeEmail)")
  List<Manager> findManagersByEmployee(@Param("employeeEmail") String employee);

}
