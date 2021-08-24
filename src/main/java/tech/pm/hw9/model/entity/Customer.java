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
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;

  @Column
  private String name;

  @Column
  private String email;

  @Column
  private int phoneNumber;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
  private List<Project> projects;
}
