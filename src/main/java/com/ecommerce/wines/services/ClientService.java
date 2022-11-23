package com.ecommerce.wines.services;

import com.ecommerce.wines.DTOS.ClientDTO;

import java.util.List;

public interface ClientService {
    public List<ClientDTO> getClientsDTO();

    public ClientDTO getClientDTO(Long id);


}
