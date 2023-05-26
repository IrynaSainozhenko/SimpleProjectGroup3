package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }



    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();


        try (FileReader fileReader = new FileReader(fileName); 
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                User user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return users;
    }

    @Override
    public void saveNewUser(User user) {
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя пользователя: ");
            String firstName = scanner.nextLine();
            System.out.println("Введите фамилию пользователя: ");
            String lastName = scanner.nextLine();
            System.out.println("Введите возраст пользователя: ");
            int age = scanner.nextInt();
            System.out.println("Введите рост пользователя: ");
            double height = scanner.nextDouble();
            String newUser = firstName + "|" + lastName + "|" + age + "|" + height;
            bufferedWriter.write(newUser);
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println("Произошла ошибка");
        }
    }

    private static User parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);

        return new User(
                firstName, lastName, age, height
        );
    }
}
