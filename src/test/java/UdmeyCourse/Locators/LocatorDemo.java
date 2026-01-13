package UdmeyCourse.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatorDemo {
    public static void main(String[] args){
    WebDriver driver =new EdgeDriver();
    driver.get("https://www.demoblaze.com/index.html");
    driver.manage().window().maximize();
    WebElement linksize=driver.findElement(By.tagName("a"));
    System.out.println(linksize.getSize());

    WebElement imagecount=driver.findElement(By.tagName("img"));
    System.out.println(imagecount.getSize());
//Samsung galaxy s6
    //img
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
       // driver.findElement(By.linkText("Samsung galaxy s6")).click();
        //driver.findElement(By.partialLinkText("Samsung")).click();
}
}
