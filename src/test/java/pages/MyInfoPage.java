package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage {
    WebDriver driver;

    // Datos personales
    By firstNameField = By.name("firstName");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By nationalityDropdown = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1](//div[contains(text(),'Algerian')])[1]");
    By dobField = By.id("personal_DOB");
    By maritalStatusDropdown = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2](//div[contains(text(),'Single')])[1]");
    By saveButton = By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]");

    // Detalles de contacto
    By streetField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By cityField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
    By stateField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
    By postalCodeField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[6]");
    By countryDropdown = By.id("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1](//div[@class='oxd-select-text oxd-select-text--active'])[1]");

    // Pasaporte
    By passportIdField = By.xpath("(//input)[4]");
    By passportCountryDropdown = By.id("passport_passportCountry");
    By passportSave = By.xpath("(//button[normalize-space()='Save'])[1]");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPersonalDetails(String firstName, String lastName, String nationality, String dob, String maritalStatus) {
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(nationalityDropdown).sendKeys(nationality);
        driver.findElement(dobField).sendKeys(dob);
        driver.findElement(maritalStatusDropdown).sendKeys(maritalStatus);
    }

    public void enterContactDetails(String street, String city, String state, String postalCode, String country) {
        driver.findElement(By.xpath("//a[normalize-space()='Contact Details']")).click();
        driver.findElement(streetField).sendKeys(street);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(countryDropdown).sendKeys(country);
    }

    public void enterPassportDetails(String passportId, String passportCountry) {
        driver.findElement(By.xpath("//a[normalize-space()='Immigration']")).click();
        driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/div[@class='orangehrm-action-header']/button[1]")).click();
        driver.findElement(passportIdField).sendKeys(passportId);
        driver.findElement(passportSave).click();
        //driver.findElement(passportCountryDropdown).sendKeys(passportCountry);
    }

    public void saveDetails() {
        driver.findElement(saveButton).click();
    }
}