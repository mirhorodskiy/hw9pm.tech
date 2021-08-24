package tech.pm.hw9.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "managers")
public class Manager {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "manager_id")
  private Long id;

  @Column
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
  private List<Project> projects;
}
