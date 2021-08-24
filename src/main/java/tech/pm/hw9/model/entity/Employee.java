package tech.pm.hw9.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @Column(name = "employee_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String email;

  @ManyToOne
  @JsonIgnore
  private Department department;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "employees_projects", joinColumns = @JoinColumn(name = "employee_id"),
          inverseJoinColumns = @JoinColumn(name = "project_id"))
  @JsonIgnore
  private List<Project> projectsList;


}
