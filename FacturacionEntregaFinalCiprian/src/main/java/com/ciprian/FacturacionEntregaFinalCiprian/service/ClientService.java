package com.ciprian.FacturacionEntregaFinalCiprian.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Client;
import com.ciprian.FacturacionEntregaFinalCiprian.repository.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public Client saveClient(Client client) {
    return clientRepository.save(client);
  }

  public boolean deleteClient(Long id) {
    try {
      clientRepository.deleteById(id);
      return true;
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
  }

  public Optional<Client> findClientById(Long id) {
    return clientRepository.findById(id);
  }

  public Iterable<Client> findAllClients() {
    return clientRepository.findAll();

  }
}