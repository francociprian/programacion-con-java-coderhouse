package com.ciprian.FacturacionSegundaEntregaCiprian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Client;
import com.ciprian.FacturacionSegundaEntregaCiprian.repository.ClientRepository;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public Client postClient(Client client) throws Exception {
    return clientRepository.save(client);
  }

  public boolean deleteClientById(Long id) {
    try {
      clientRepository.deleteById(id);
      return true;
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
  }

  public Client getClientById(Long id) {
    Optional<Client> clientOptional = clientRepository.findById(id);
    if (clientOptional.isPresent()) {
      return clientOptional.get();
    } else {
      return null;
    }
  }

  public List<Client> getAllClients() {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

}
