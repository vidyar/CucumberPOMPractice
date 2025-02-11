package Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
    @Test
    public void fileUpload() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        upload.sendKeys("/Users/aneesh/Documents/Vidya/sample/test.txt");
    }
}
