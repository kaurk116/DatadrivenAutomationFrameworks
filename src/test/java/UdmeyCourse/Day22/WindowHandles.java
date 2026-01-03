package UdmeyCourse.Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'OrangeHRM')]")));
       // driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        //driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Set<String> windowId = driver.getWindowHandles();
        for (String newwindow : windowId) {
            String title = driver.switchTo().window(newwindow).getTitle();
            if (title.equals("Human Resources Management Software | HRMS | OrangeHRM") || title.equals("OrangeHRM"));
            System.out.println(driver.getCurrentUrl());
            {
                driver.close();
            }
        }
    }
}