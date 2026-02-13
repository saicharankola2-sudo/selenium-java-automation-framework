package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver initDriver()
    {
        String browser = System.getProperty("browser");

        if(browser==null || browser.isEmpty()) {
            browser = ConfigReader.getBrowser();
        }
        if(browser==null || browser.isEmpty()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase())
        {
            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
               driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                System.out.println("Browser not defined, initiated chrome driver---");
                driver.set(new ChromeDriver());
        }
        getDriver().manage().window().maximize();
        return getDriver();

    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void closeDriver(){

        if(driver.get()!=null)
            driver.get().close();

    }

    public static void quitDriver()
    {
        WebDriver webDriver = driver.get();

        if(webDriver!=null)
        {
            webDriver.quit();
            driver.remove();
        }


    }
}
