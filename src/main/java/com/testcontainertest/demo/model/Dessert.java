package com.testcontainertest.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "desserts")
public class Dessert {

  @Id
  private String name;
}