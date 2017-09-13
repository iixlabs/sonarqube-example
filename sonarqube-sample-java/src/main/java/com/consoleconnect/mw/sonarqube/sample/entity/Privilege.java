package com.consoleconnect.mw.sonarqube.sample.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Privilege {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;


  @ManyToMany(mappedBy = "privileges")
  private Collection<Role> roles;


  public Privilege withName(String name) {
    this.name = name;
    return this;
  }
}
