package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.*;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }
        return names;
    }

    @Override
    public String getLastNameOfMostAging() {
        List<User> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (User user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }

        int maxAge = Collections.max(userAge.keySet());

        return userAge.get(maxAge);
    }

    public User createNewUser(String firstNameUser, String lastNameUser, int ageUser, double heightUser){
        return new User(firstNameUser, lastNameUser, ageUser, heightUser);
    }


    @Override
    public double getAverageAgeOfUsers() {
        List<User> users = usersRepository.findAll();
        double tempSum = 0.0;
        if (users.size() == 0)
            return 0.0;
        for (User user : users)
            tempSum += user.getAge();
        return tempSum/users.size();
    }
    @Override
    public int getAgeOfTheHighest(){
        List<User> users = usersRepository.findAll();
        Map<Double, Integer> userHeight = new HashMap<>();
        for (User user : users) {
            userHeight.put(user.getHeight(), user.getAge());
        }
        double maxHeight = Collections.max(userHeight.keySet());
        return userHeight.get(maxHeight);
    }
    @Override
    public String getShortestPersonFullName() {
        List<User> users = usersRepository.findAll();
        if (users.isEmpty()) {
            return "";
        }
        User shortestUser = users.get(0);
        for (int i = 1; i < users.size(); i++) {
            if (users.get(i).getHeight() < shortestUser.getHeight()) {
                shortestUser = users.get(i);
            }
        }
        return shortestUser.getFirstName() + " " + shortestUser.getLastName();
    }
}
