package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users = new ArrayList<>(List.of(
            new User("Amina", "Zolotoverkh", 20, 1.71),
            new User("Andrey", "Didenko", 25, 1.85),
            new User("Dmytro", "Lukash", 30, 1.90)
    ));
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void saveNewUser(User user) {
        users.add(user);
    }
}
