package com.ecommerce.wines.services;

import com.ecommerce.wines.DTOS.ClientDTO;
import com.ecommerce.wines.models.Client;

import java.util.List;

public interface ClientService {
    public List<ClientDTO> getClientsDTO();

    public ClientDTO getClientDTO(Long id);

    public Client clientFindByEmail(String email);

    public void saveClient(Client client);


}
