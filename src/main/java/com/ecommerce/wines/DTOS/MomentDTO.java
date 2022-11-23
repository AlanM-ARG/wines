package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.Moment;

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



    public long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
