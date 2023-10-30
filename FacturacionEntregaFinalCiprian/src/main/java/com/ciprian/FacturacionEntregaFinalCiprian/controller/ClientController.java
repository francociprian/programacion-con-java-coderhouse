package com.ciprian.FacturacionEntregaFinalCiprian.controller;

import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Client;
import com.ciprian.FacturacionEntregaFinalCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionEntregaFinalCiprian.service.ClientService;

@RestController
@RequestMapping("api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Save a new client", description = "Save a new client", tags = { "Client" })
    @PostMapping(value = "/client", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> save(@RequestBody Client client) {
        try {
            System.out.println(client);
            Client clientSaved = clientService.saveClient(client);
            return ResponseHandler.generateResponse(
                    "Client saved",
                    HttpStatus.OK,
                    clientSaved);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @Operation(summary = "Get a client by ID", description = "Get a client by ID", tags = { "Client" })
    @GetMapping(value = "/client/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getClientById(@PathVariable Long id) {
        try {
            Optional<Client> client = clientService.findClientById(id);

            if (client != null) {
                return ResponseHandler.generateResponse(
                        "Client found",
                        HttpStatus.OK,
                        client);
            } else {
                return ResponseHandler.generateResponse(
                        "Client not found",
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

    @Operation(summary = "Get all clients", description = "Get all clients", tags = { "Client" })
    @GetMapping(value = "/client/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getAllClients() {
        try {
            Iterable<Client> clients = clientService.findAllClients();
            return ResponseHandler.generateResponse(
                    "Clients",
                    HttpStatus.OK,
                    clients);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @Operation(summary = "Delete a client by ID", description = "Delete a client by ID", tags = { "Client" })
    @DeleteMapping(path = "/client/{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable Long id) {
        try {
            boolean deleted = clientService.deleteClient(id);

            if (deleted) {
                return ResponseHandler.generateResponse(
                        "Client deleted successfully",
                        HttpStatus.OK,
                        null);
            } else {
                return ResponseHandler.generateResponse(
                        "Client not found",
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
