package com.ciprian.FacturacionEntregaFinalCiprian.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Product;
import com.ciprian.FacturacionEntregaFinalCiprian.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public boolean deleteProduct(Long id) {
    try {
      productRepository.deleteById(id);
      return true;
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
  }

  public Optional<Product> findProductById(Long id) {
    return productRepository.findById(id);
  }

  public Iterable<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public double getPriceProductByID(Long productId) {
    var product = productRepository.findById(productId);

    if (product.isPresent()) {
      return product.get().getPrice();
    } else {
      throw new NoSuchElementException("Product not found for ID: " + productId);
    }
  }

  public Long updateStockWithSell(Long productId, Long stock) {
    var product = productRepository.findById(productId);

    if (product.isPresent()) {
      Product foundProduct = product.get();
      foundProduct.setStock(foundProduct.getStock() - stock);
      productRepository.save(foundProduct);

      return foundProduct.getStock();
    } else {
      throw new NoSuchElementException("Product not found for ID: " + productId);
    }
  }

}
