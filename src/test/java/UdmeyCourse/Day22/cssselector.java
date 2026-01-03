package UdmeyCourse.Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class cssselector {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        //tag id      tag#id
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("phone");
       // driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("phone");

        //tag id      tag#class
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("phone");
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("phone");

        //tag id  attribute name
        //driver.findElement(By.cssSelector("input[aria-label=\"Search store\"]")).sendKeys("phone");
        //driver.findElement(By.cssSelector("[aria-label=\"Search store\"]")).sendKeys("phone");
        ////tag id  class[attribute name]

        //driver.findElement(By.cssSelector("input.search-box-text[aria-label=\"Search store\"]")).sendKeys("phone");
        driver.findElement(By.cssSelector(".search-box-text[aria-label=\"Search store\"]")).sendKeys("phone");



    }
}