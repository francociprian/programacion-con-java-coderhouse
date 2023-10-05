package com.ciprian.FacturacionSegundaEntregaCiprian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Product;
import com.ciprian.FacturacionSegundaEntregaCiprian.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product) throws Exception {
    return productRepository.save(product);
  }

  public boolean deleteProductById(Long id) {
    try {
      productRepository.deleteById(id);
      return true;
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
  }

  public List<Product> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products;
  }

  public Product getProductById(Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (product.isPresent()) {
      return product.get();
    } else {
      return null;
    }
  }

}
