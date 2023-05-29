import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.services.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
    private UsersServiceImpl usersService;
    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());
    }

    //    1. Вывести имена всех пользователей
    @Test
    void getNames() {
        List<String> actual = usersService.getNames();
        List<String> expected = List.of("Amina", "Andrey", "Dmytro");
        Assertions.assertEquals(expected, actual);
    }

    //  2. Вывести фамилию самого взрослого пользователя
    @Test
    public void getLastNameOfMostAging() {
        String actuals = usersService.getLastNameOfMostAging();
        String expected = "Lukash";
        assertEquals(expected, actuals);
    }

    //  4. Вывести средний возраст всех пользователей
    @Test
    public void getAverageAgeOfUsers() {
        double actuals = usersService.getAverageAgeOfUsers();
        double expected = (20 + 25 + 30) / 3;
        assertEquals(expected, actuals);
    }

    //  5. Вывести возраст самого высокого человека
    @Test
    void getAgeOfTheHighest(){
        int actual = usersService.getAgeOfTheHighest();
        int expected = 30;
        assertEquals(expected,actual);
    }

//    6. Вывести имя и фамилию самого низкого человека
    @Test
    public void getShortestPersonFullName(){
        String actuals = usersService.getShortestPersonFullName();
        String expected = "Amina Zolotoverkh";
        assertEquals(expected, actuals);
    }
}