package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Favs;

public class FavsDTO {


    private long id;
    private String name;
    private String image;

    private boolean active;



    public FavsDTO(Favs favs) {
        this.id = favs.getId();
        this.name = favs.getName();
        this.image = favs.getImage();
        this.active = favs.isActive();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public boolean isActive() {
        return active;
    }

}
