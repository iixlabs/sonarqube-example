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
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @NotEmpty
  private String username;
  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @NotEmpty
  private String password;

  private boolean enabled;
  private boolean tokenExpired;

  @ManyToMany
  @JoinTable(name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<Role> roles;


  public User withId(long id) {
    this.id = id;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public User withPassword(String password) {
    this.password = password;
    return this;
  }

  public User withUsername(String username) {
    this.username = username;
    return this;
  }

  public User withRoles(Collection<Role> roles) {
    this.roles = roles;
    return this;
  }
}
