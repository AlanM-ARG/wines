package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Favs;

public class FavsDTO {


    private long id;
    private String name;
    private String imagen;


    public FavsDTO(Favs favs) {
        this.id = favs.getId();
        this.name = favs.getName();
        this.imagen = favs.getImagen();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagen() {
        return imagen;
    }
}
