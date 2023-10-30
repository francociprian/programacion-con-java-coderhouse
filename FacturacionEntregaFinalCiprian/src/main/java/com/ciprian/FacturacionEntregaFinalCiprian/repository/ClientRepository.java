package com.ciprian.FacturacionEntregaFinalCiprian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
