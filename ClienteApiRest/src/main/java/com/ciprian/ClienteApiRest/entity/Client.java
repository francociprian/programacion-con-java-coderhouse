package com.ciprian.ClienteApiRest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String lastname;
  private int birthday;
  private int birthmonth;
  private int birthyear;

  public Client() {
  }
  public Client(int id, String name, String lastname,int birthday, int birthmonth,int birthyear) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.birthday = birthday ;
    this.birthmonth = birthmonth ;
    this.birthyear = birthyear ;
}

  // Getters and setters
  public int getBirthday() {
    return birthday;
  }

  public void setBirthday(int birthday) {
    this.birthday = birthday;
  }

  public int getBirthmonth() {
    return birthmonth;
  }

  public void setBirthmonth(int birthmonth) {
    this.birthmonth = birthmonth;
  }

  public int getBirthyear() {
    return birthyear;
  }

  public void setBirthyear(int birthyear) {
    this.birthyear = birthyear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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
}