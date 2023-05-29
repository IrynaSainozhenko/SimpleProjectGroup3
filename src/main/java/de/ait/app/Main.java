package de.ait.app;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {

        System.out.println(ANSI_CYAN +
                "\nДобро пожаловать в приложение разработанное участниками 3 группы");
        System.out.println(ANSI_PURPLE +
                "\nДля продолжения выберите нужный вариант из списка:" + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository);

        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");
            System.out.println("0. Выход");

            int command = 0;
            if(scanner.hasNextInt()){
                command = scanner.nextInt();
                scanner.nextLine();
                switch (command) {
                    case 1:
                        System.out.println(ANSI_BLUE + "Выводим имена всех пользователей" + ANSI_RESET);
                        List<String> names = usersService.getNames();
                        for (String name : names) {
                            System.out.println(name);
                        }
                        break;

                    case 2:
                        System.out.println(ANSI_BLUE + "Выводим самого взрослого пользователя" + ANSI_RESET);
                        String lastName = usersService.getLastNameOfMostAging();
                        System.out.println(lastName);
                        break;

                    case 3:
                        System.out.println(ANSI_BLUE + "Сохраняем нового пользователя" + ANSI_RESET);
                        System.out.println("Введите имя пользователя: ");
                        String firstNameUser = scanner.nextLine();

                        System.out.println("Введите фамилию пользователя: ");
                        String lastNameUser = scanner.nextLine();

                        System.out.println("Введите возраст пользователя: ");
                        int ageUser = 0;
                        if (scanner.hasNextInt()) {
                            ageUser = scanner.nextInt();
                            if(ageUser < 1){
                                System.out.println("Возраст не может быть отрицательным " +
                                        "или равным '0'!");
                                System.out.println("Перезапустите программу!");
                                return;
                            }
                        } else {
                            System.out.println("Введенное значение не является числом!");
                            System.out.println("Перезапустите программу!");
                            return;
                        }

                        System.out.println("Введите рост пользователя: ");
                        double heightUser = 0;
                        if (scanner.hasNextDouble()) {
                            heightUser = scanner.nextDouble();
                            if (heightUser < 1){
                                System.out.println("Возраст не может быть отрицательным " +
                                        "или равным '0'!");
                                System.out.println("Перезапустите программу!");
                                return;
                            }
                        } else {
                            System.out.println("Введенное значение не является числом!");
                            System.out.println("Перезапустите программу!");
                            return;
                        }

                        User newUser = usersService.createNewUser(firstNameUser, lastNameUser, ageUser, heightUser);
                        usersRepository.saveNewUser(newUser);
                        break;

                    case 4:
                        System.out.println(ANSI_BLUE + "Выводим средний возраст всех пользователей"+ ANSI_RESET);
                        double averageAge = usersService.getAverageAgeOfUsers();
                        System.out.println(averageAge);
                        break;

                    case 5:
                        System.out.println(ANSI_BLUE + "Выводим возраст самого высокого человека"+ ANSI_RESET);
                        double maxHeight = usersService.getAgeOfTheHighest();
                        System.out.println(maxHeight);
                        break;

                    case 6:
                        System.out.println(ANSI_BLUE + "Выводим имя и фамилию самого низкого человека"+ ANSI_RESET);
                        String firstNameAndLastName = usersService.getShortestPersonFullName();
                        System.out.println(firstNameAndLastName);
                        break;

                    case 0:
                        System.out.println(ANSI_BLUE + "Выход"+ ANSI_RESET);
                        System.exit(0);
                    default:
                        System.out.println("Команда не распознана");
                }
            } else{
                System.out.println("Введенное значение не является числом!");
                System.out.println("Перезапустите программу!");
                return;
            }
        }
    }
}
