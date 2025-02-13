package configs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        tags = "@testAserciones",
        publish = true
)

public class RunCucumber {

    public RunCucumber()
    {

    }

    @AfterClass
    public static void quitDriver()
    {
        System.out.println("Cerrando el webdriver");
        WebDriverManager.driver.quit();
    }



}
