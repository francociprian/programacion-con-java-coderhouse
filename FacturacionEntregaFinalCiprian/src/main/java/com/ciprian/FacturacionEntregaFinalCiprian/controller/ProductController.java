package com.ciprian.FacturacionEntregaFinalCiprian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Product;
import com.ciprian.FacturacionEntregaFinalCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionEntregaFinalCiprian.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Save a new product", description = "Save a new product", tags = { "Product" })
    @PostMapping(value = "/product", consumes = { MediaType.APPLICATION_JSON_VALUE })
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

    @Operation(summary = "Get a product by ID", description = "Get a product by ID", tags = { "Product" })
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        try {
            Optional<Product> product = productService.findProductById(id);

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

    @Operation(summary = "Get all products", description = "Get all products", tags = { "Product" })
    @GetMapping("/product/all")
    public ResponseEntity<Object> getAllProducts() {
        try {
            Iterable<Product> products = productService.findAllProducts();
            return ResponseHandler.generateResponse(
                    "All Products",
                    HttpStatus.OK,
                    products);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @Operation(summary = "Delete a product by ID", description = "Delete a product by ID", tags = { "Product" })
    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable Long id) {
        try {
            boolean deleted = productService.deleteProduct(id);

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
}
