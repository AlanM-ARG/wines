package com.ecommerce.wines.repositories;

import com.ecommerce.wines.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long>{

    Client findByEmail(String email);

    Client findByToken(String token);

}

