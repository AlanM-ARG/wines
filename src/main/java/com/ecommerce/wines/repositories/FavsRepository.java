package com.ecommerce.wines.repositories;

import com.ecommerce.wines.models.Favs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FavsRepository extends JpaRepository<Favs, Long> {
}
