package com.example.pets.models;

import java.io.Serializable;

public class Client implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private long CPF;

    public Client() {
    }

    public Client(String name, String surname, long CPF, String email) {
        this.name = name;
        this.CPF = CPF;
        this.surname = surname;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){
        return String.format("%s %s", name, surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

}
