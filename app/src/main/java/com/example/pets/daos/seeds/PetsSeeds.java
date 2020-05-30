package com.example.pets.daos.seeds;

import com.example.pets.daos.PetDAO;
import com.example.pets.models.Pet;

import java.util.ArrayList;
import java.util.List;


public class PetsSeeds {

     public static List<Pet> getCollection() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Ozzy", "Cachorro", "Pitbull", "Gabriel Camargo"));
        pets.add(new Pet("Bob", "Cachorro", "Golden Retriever", "Lucas Barreto"));
        pets.add(new Pet("Miau", "Gato", "Persian cat", "Nicholas"));
        pets.add(new Pet("AuAu", "Cachorro", "Pastor Alemão", "Brenda"));
        return pets;
    }

    public static void install(PetDAO petDAO){
        for (Pet pet : getCollection()){
            petDAO.insert(pet);
        }
    }
}
