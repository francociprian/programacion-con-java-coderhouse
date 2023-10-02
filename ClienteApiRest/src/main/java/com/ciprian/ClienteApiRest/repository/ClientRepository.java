package com.ciprian.ClienteApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciprian.ClienteApiRest.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}