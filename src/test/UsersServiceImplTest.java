import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.services.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<String> expected = List.of("User1", "User2", "User3");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getAgeOfTheHighest(){
        int actual = usersService.getAgeOfTheHighest();
        int expected = 30;
        assertEquals(expected,actual);
    }


}