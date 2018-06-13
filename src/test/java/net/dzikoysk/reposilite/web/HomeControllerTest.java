package net.dzikoysk.reposilite.web;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {

    @Autowired
    private HomeController controller;

    // @Test
    public void contextLoads() {
        Assert.assertNotNull(controller);
    }

}
