package net.learningproj.journalApp.service;

import net.learningproj.journalApp.entity.User;
import net.learningproj.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "manav",
            "pancham",
            "hello"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName("manav"));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12"
    })
    public void test(int a, int c, int expected){
        assertEquals(expected, a+c);
    }
}
