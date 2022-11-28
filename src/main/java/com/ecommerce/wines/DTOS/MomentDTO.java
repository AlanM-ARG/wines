package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.Moment;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MomentDTO {

    private long id;

    private String img;

    private String title;

    private String description;

    private Client client;


    public MomentDTO() {
    }

    public MomentDTO(Moment moment) {
        this.id = moment.getId();
        this.img = moment.getImg();
        this.title = moment.getTitle();
        this.description = moment.getDescription();
        this.client = moment.getClient();
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
