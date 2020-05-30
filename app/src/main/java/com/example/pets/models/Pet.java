package com.example.pets.models;

import java.io.Serializable;

public class Pet implements Serializable {

    private Integer id;
    private String name;
    private String specie;
    private String breed;
    private Client owner;

    public Pet() {
    }

    public Pet(String name, String specie, String breed, Client owner) {
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
