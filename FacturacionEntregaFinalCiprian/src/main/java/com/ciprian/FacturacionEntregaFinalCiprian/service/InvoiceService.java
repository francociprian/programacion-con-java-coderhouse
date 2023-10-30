package com.ciprian.FacturacionEntregaFinalCiprian.service;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Client;
import com.ciprian.FacturacionEntregaFinalCiprian.entity.Invoice;
import com.ciprian.FacturacionEntregaFinalCiprian.entity.InvoiceDetails;
import com.ciprian.FacturacionEntregaFinalCiprian.repository.InvoiceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public boolean deleteInvoice(Long id){
        try {
            invoiceRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Invoice findInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            return invoice.get();
        } else {
            return null;
        }
    }

    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }


    public Invoice saveInvoice(Invoice invoice) {
        // Obtener la hora actual
        Date currentDate = getCurrentDateTime();

        // Validar la existencia del cliente
        Long clientId = invoice.getClient().getId();
        Client client = getClientById(clientId);

        // Actualizar el stock de productos y calcular el total de la factura
        updateProductStockAndCalculateTotal(invoice);

        // Establecer la fecha de creación y el cliente en la factura
        invoice.setCreatedAt(currentDate);
        invoice.setClient(client);

        // Guardar la factura
        return save(invoice);
    }

    private Date getCurrentDateTime() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(
                "http://worldclockapi.com/api/json/utc/now",
                String.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode root = objectMapper.readTree(response.getBody());
                String currentDateString = root.get("currentDateTime").asText();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                return simpleDateFormat.parse(currentDateString);
            }
        } catch (Exception e) {
            return new Date();
        }

        // Si se produce una excepción o el estado no es "2xxSuccessfull", retorna una fecha predeterminada.
        return new Date();
    }

    private Client getClientById(Long clientId) {
        Optional<Client> clientOptional = clientService.findClientById(clientId);
        if (clientOptional.isEmpty()) {
            throw new RuntimeException("The client does not exist");
        }
        return clientOptional.get();
    }

    private void updateProductStockAndCalculateTotal(Invoice invoice) {
        int totalProduct = 0;
        double totalAmount = 0;

        List<InvoiceDetails> details = invoice.getInvoiceDetails();
        if (details != null) {
            for (InvoiceDetails id : details) {
                Long productId = id.getProduct().getProductId();
                Long amount = id.getAmount();

                // Actualizar el stock de productos
                Long newStockWithSell = productService.updateStockWithSell(productId, amount);
                if (newStockWithSell < 0) {
                    throw new RuntimeException("There is not enough stock for the product with ID " + productId);
                }

                // Actualizar el stock del producto en la factura
                id.getProduct().setStock(newStockWithSell);

                // Calcular el precio por producto y actualizar los totales
                double productPrice = productService.getPriceProductByID(id.getProduct().getProductId());
                id.setPrice(productPrice * amount);
                totalAmount += id.getPrice();
                totalProduct += amount;
            }
        }

        invoice.setTotalProduct(totalProduct);
        invoice.setTotal(totalAmount);
    }

}

