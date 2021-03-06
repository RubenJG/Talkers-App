package app.talkers.zuul;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles({"default", "test"})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZuulTests {

    private static final Logger log = LoggerFactory.getLogger(ZuulTests.class);

    @Test
    public void contextLoads() {
        log.info("Context Loaded!");
    }
}
