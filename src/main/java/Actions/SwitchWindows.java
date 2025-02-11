package Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SwitchWindows {
    @Test
    public void myTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://facebook.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://gmail.com");

        System.out.println(driver.getTitle());

        ArrayList<String> windows= new ArrayList<>(driver.getWindowHandles());

        Thread.sleep(3000);
        driver.switchTo().window(windows.get(1));
        System.out.println(driver.getTitle());

    }
}
