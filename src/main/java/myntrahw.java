import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class myntrahw {

        @Test
        public void hoverTshirt() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.myntra.com/");

            Actions action = new Actions(driver);
            WebElement menMenu = driver.findElement(By.xpath("//a[@data-group='men']"));
            action.moveToElement(menMenu).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement tShirtsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href, '/men-tshirts')]")));
            tShirtsOption.click();
            driver.quit();
        }
    }

