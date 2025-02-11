package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static util.Reader.getUrl;

public class SharedSD {
    public static WebDriver driver;
    @Before

    public void openUrl()
    {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(getUrl());
    }
    @After
    public void closeBrowser()
    {
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
