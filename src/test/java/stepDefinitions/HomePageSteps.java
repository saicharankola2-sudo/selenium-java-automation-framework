package stepDefinitions;

import drivers.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {

    private HomePage homePage;

    @Given("Launch url")
    public void launchUrl() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.launchUrl();
    }

    @Then("Check second step")
    public void checkSecondStep() {
        homePage.secondStep();

    }
}
