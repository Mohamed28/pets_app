package com.example.pets.daos.seeds;

import com.example.pets.daos.UserDAO;
import com.example.pets.enums.Roles;
import com.example.pets.models.User;

import java.util.ArrayList;
import java.util.List;


public class UsersSeeds{

     public static List<User> getCollection() {
        List<User> users = new ArrayList<>();
        users.add(new User("Lucas", "Barretto", 00011122233L, "password_1", 1133445566, Roles.SALESMAN.value, true));
        users.add(new User("Gabriel", "Camargo", 11122233344L, "password_2", 1144556677, Roles.MANAGER.value, false));
        users.add(new User("Nicholas", "Muniz", 22233344455L, "password_3", 1155667788, Roles.SUPPLIER.value, true));
        users.add(new User("Brenda", "Glicéria", 33344455566L, "password_4", 1166778899, Roles.PRESIDENT.value, false));
        return users;
    }

    public static void install(UserDAO userDAO){
        for (User user : getCollection()){
            userDAO.insert(user);
        }
    }
}
