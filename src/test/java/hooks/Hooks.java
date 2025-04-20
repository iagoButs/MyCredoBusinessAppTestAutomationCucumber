package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.SneakyThrows;
import utills.AppRunner;

public class Hooks {

    @SneakyThrows
    @Before
    public void setup(){
        AppRunner.setupCapabilities();
    }

    @After
    public void tearDown(){
        AppRunner.tearDown();
    }
}
