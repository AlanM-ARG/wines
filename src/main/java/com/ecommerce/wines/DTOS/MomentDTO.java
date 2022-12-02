package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.Moment;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MomentDTO {

    private long id;

    private String image;

    private String title;

    private String description;

    private Client client;

    private boolean active;

    public MomentDTO(Moment moment) {
        this.id = moment.getId();
        this.image = moment.getImage();
        this.title = moment.getTitle();
        this.description = moment.getDescription();
        this.client = moment.getClient();
        this.active = moment.isActive();
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }
}
