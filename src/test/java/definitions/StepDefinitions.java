package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MyInfoPage;

public class StepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    MyInfoPage myInfoPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @When("the user enters their personal details")
    public void the_user_enters_their_personal_details() throws InterruptedException {
        myInfoPage = new MyInfoPage(driver);
        Thread.sleep(1000);
        myInfoPage.enterPersonalDetails("Juan", "Perez", "Mexican", "1990-02-12", "Single");
    }

    @When("the user enters their contact details")
    public void the_user_enters_their_contact_details() {
        myInfoPage.enterContactDetails("Calle Ficticia 123", "Ciudad Ficticia", "Estado Ficticio", "12345", "Mexico");
    }

    @When("the user enters their passport details")
    public void the_user_enters_their_passport_details() {
        myInfoPage.enterPassportDetails("A12345678", "Mexico");
    }

    @Then("the user information should be saved and visible correctly")
    public void the_user_information_should_be_saved_and_visible_correctly() {
        myInfoPage.saveDetails();
        // Aquí deberías agregar verificaciones para asegurarte de que los datos se hayan guardado correctamente
        // Por ejemplo:
        // assertEquals("Juan", myInfoPage.getFirstName());
        // assertEquals("Perez", myInfoPage.getLastName());
        // etc.
    }
}