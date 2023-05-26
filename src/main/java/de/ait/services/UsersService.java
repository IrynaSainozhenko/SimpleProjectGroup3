package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    double getAverageAgeOfUsers();

    int getAgeOfTheHighest();

    String getShortestPersonFullName();

    User createNewUser(String firstNameUser, String lastNameUser, int ageUser, double heightUser);
}
