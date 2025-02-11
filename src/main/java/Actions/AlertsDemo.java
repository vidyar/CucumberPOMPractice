package Actions;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {
    @Test
    public void fileUpload() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");
        WebElement Clickbtn = driver.findElement(By.name("submit"));
        Clickbtn.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement TryITbtn = driver.findElement(By.xpath(" //button[text()='Try it']"));
        TryITbtn.click();
        Thread.sleep(3000);
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
    }

}
