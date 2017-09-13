package com.consoleconnect.mw.sonarqube.sample.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;


  @ManyToMany(mappedBy = "roles")
  private Collection<User> users;

  @ManyToMany
  @JoinTable(name = "roles_privileges",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  private Collection<Privilege> privileges;


  public Role withName(String name) {
    this.name = name;
    return this;
  }

  public Role withPrivileges(Collection<Privilege> privileges) {
    this.privileges = privileges;
    return this;
  }
}
