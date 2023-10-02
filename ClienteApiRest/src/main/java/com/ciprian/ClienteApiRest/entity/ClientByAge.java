package com.ciprian.ClienteApiRest.entity;

public class ClientByAge {
  private String name;
  private String lastname;
  private int age;

  public ClientByAge() {
  }
  // Constructor
  public ClientByAge(String name, String lastname, int age) {
    this.name = name;
    this.lastname = lastname;
    this.age = age;
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
