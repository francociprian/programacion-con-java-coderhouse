package com.ciprian.FacturacionSegundaEntregaCiprian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Product;
import com.ciprian.FacturacionSegundaEntregaCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionSegundaEntregaCiprian.service.ProductService;

@RestController
@RequestMapping(path = "/api")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping(path = "/product")
  public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
    try {
      System.out.println(product);
      Product createdProduct = productService.saveProduct(product);
      return ResponseHandler.generateResponse(
          "Product saved",
          HttpStatus.OK,
          createdProduct);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @DeleteMapping(path = "/product/{id}")
  public ResponseEntity<Object> deleteProductById(@PathVariable Long id) {
    try {
      boolean deleted = productService.deleteProductById(id);

      if (deleted) {
        return ResponseHandler.generateResponse(
            "Product deleted successfully",
            HttpStatus.OK,
            null);
      } else {
        return ResponseHandler.generateResponse(
            "Product not found",
            HttpStatus.NOT_FOUND,
            null);
      }
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/products")
  public ResponseEntity<Object> getAllProducts() {
    try {
      List<Product> products = productService.getAllProducts();
      return ResponseHandler.generateResponse(
          "Products",
          HttpStatus.OK,
          products);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/product/{id}")
  public ResponseEntity<Object> getProductById(@PathVariable Long id) {
    try {
      Product product = productService.getProductById(id);

      if (product != null) {
        return ResponseHandler.generateResponse(
            "Product found",
            HttpStatus.OK,
            product);
      } else {
        return ResponseHandler.generateResponse(
            "Product not found",
            HttpStatus.NOT_FOUND,
            null);
      }
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

}
