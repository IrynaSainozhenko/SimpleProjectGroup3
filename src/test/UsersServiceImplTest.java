import de.ait.app.Main;
import de.ait.models.User;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());

    }

    @Test
    void getNames() {
        List<String> actual = usersService.getNames();
        List<String> expected = List.of("Amina", "Andrey", "Dmytro");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameOfMostAging() {
        String actuals = usersService.getLastNameOfMostAging();
        String expected = "Lukash";
        assertEquals(expected, actuals);
    }

    @Test
    public void getAverageAgeOfUsers() {
        double actuals = usersService.getAverageAgeOfUsers();
        double expected = (20 + 25 + 30) / 3;
        assertEquals(expected, actuals);
    }

    @Test
    void getAgeOfTheHighest(){
        int actual = usersService.getAgeOfTheHighest();
        int expected = 30;
        assertEquals(expected,actual);
    }

    @Test
    public void getShortestPersonFullName(){
        String actuals = usersService.getShortestPersonFullName();
        String expected = "Amina Zolotoverkh";
        assertEquals(expected, actuals);
    }

}