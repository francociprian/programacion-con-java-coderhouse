package com.ciprian.ClienteApiRest.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciprian.ClienteApiRest.entity.Client;
import com.ciprian.ClienteApiRest.entity.ClientByAge;
import com.ciprian.ClienteApiRest.repository.ClientRepository;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public Client postClient(Client client) throws Exception {
    return clientRepository.save(client);
  }

  public ClientByAge getClient(int id) throws Exception {
    Optional<Client> cliente = clientRepository.findById(id);
    if (cliente.isEmpty()) {
      return null;
    } else {
      // Obteniendo los datos del cliente.
      Client client = cliente.get();

      // Calculando la edad en base a la fecha de nacimiento.
      LocalDate birthday = LocalDate.of(
        client.getBirthyear(),
        client.getBirthmonth(),
        client.getBirthday()
      );

      int age = calculateAge(birthday);

      // Creando ClientByAge usando los datos del cliente, el mismo retorna sólo los campos solicitados.
      ClientByAge ClientByAge = new ClientByAge(
        client.getName(), 
        client.getLastname(), 
        age
      );
      return ClientByAge;
    }
  }

  // Lógica para calcular la edad.
  public static int calculateAge(LocalDate birthday) {
    LocalDate currentDate = LocalDate.now();
    Period period = Period.between(birthday, currentDate);
    return period.getYears();
  }

  public List<Client> getAllClients() {
    // Esto es solo una prueba mia para obtener todos los clientes desde tu base de datos //.
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

}
