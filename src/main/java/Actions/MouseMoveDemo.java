
package Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseMoveDemo {
    @Test
    public void myTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        WebElement lnkMen = driver.findElement(By.xpath("//a[@data-group='men']"));
        Actions action = new Actions(driver);
        action.moveToElement(lnkMen).perform();
        WebElement jeans = driver.findElement(By.xpath("//a[text()='Jeans'][@href='/men-jeans']"));
        jeans.click();

    }
    @Test
    public void myTest2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        WebElement lnkWoMen = driver.findElement(By.xpath("//a[@data-group='women']"));
        Actions action = new Actions(driver);
        action.moveToElement(lnkWoMen).perform();
        WebElement sarees = driver.findElement(By.xpath("//a[text()='Sarees'][@href='/saree']"));
        sarees.click();


    }
}





