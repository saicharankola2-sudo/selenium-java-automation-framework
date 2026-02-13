package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }


    public void launchUrl()
    {
        driver.get(ConfigReader.getUrl());
    }

    public void secondStep()
    {
        driver.findElement(By.xpath("")).click();
    }
}
