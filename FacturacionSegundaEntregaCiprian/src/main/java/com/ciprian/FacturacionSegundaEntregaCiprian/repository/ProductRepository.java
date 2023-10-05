package com.ciprian.FacturacionSegundaEntregaCiprian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}