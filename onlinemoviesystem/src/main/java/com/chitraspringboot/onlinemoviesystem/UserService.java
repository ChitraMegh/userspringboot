package com.chitraspringboot.onlinemoviesystem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        // create some sample users
        User user1 = new User("Alice", "alice@example.com", "123-456-7890");
        User user2 = new User("Bob", "bob@example.com", "987-654-3210");

        // add them to the user list
        users.addAll(Arrays.asList(user1, user2));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String email, User updatedUser) {
        User user = getUserByEmail(email);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setPhone(updatedUser.getPhone());
        }
    }

    public void deleteUser(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            users.remove(user);
        }
    }
}
