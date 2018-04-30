package com.loyer.hrsystem;

import com.loyer.hrsystem.model.User;
import com.loyer.hrsystem.repository.UserRepository;
import com.loyer.hrsystem.service.UserService;
import com.loyer.hrsystem.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * User kaydı testi
 * kaydedilen kullanıcı sistemde var mı
 * yok mu ona bakıyoruz
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {


    @TestConfiguration
    static class UserServiceImplTestContextConfiguration{

        @Autowired
        private UserRepository userRepository;
        @Bean
        UserService userService(){
            return new UserServiceImpl(userRepository);
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private  UserRepository userRepository;
    @Before
    public void setUp(){
        User user1 = new User("recep", "123456");
        user1.setName("recep");
        user1.setLastName("çelik");
        userRepository.save(user1);

        Mockito.when(userRepository.findByUsername(user1.getUsername()))
                .thenReturn(user1);

    }

    @Test
    public void Valid(){
        String name = "recep";
        User found = userService.getUserByUsername(name);

        assertThat(found.getUsername())
                .isEqualTo(name);
    }
}
