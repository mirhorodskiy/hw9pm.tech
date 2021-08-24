package tech.pm.hw9.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "project_id")
  private Long id;

  @Column
  private String projectName;

  @ManyToOne
  private Manager manager;

  @ManyToMany(mappedBy = "projectsList")
  @JsonIgnore
  private List<Employee> team;

  @ManyToOne
  private Customer customer;
}
