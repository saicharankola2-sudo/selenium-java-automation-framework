package hooks;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setupDriver()
    {
        DriverFactory.initDriver();

    }
    @After
    public void tearDown()
    {
        DriverFactory.quitDriver();

    }

}
