package UdmeyCourse.MouseEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class AssignmentDoubleClick {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        field1.clear();
        field1.sendKeys("Karmjeet kaur");

        Actions act = new Actions(driver);
        act.doubleClick(button).build().perform();

        String value = field2.getAttribute("value");

        System.out.println("Copy of value is: " + value);
        if (value.equals("Karmjeet kaur")) {
            System.out.println("Copy of value is");
        } else {
            System.out.println("Copy of value is not copy");
        }

        //Drag Drop

        WebElement Source  = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target =driver.findElement(By.xpath("//div[@id='droppable']"));

        act.dragAndDrop(Source,target);

        driver.quit();

    }
}