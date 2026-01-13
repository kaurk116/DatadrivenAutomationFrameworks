package UdmeyCourse.BrokenLinkSVG;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class ShadowDomAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://dev.automationtesting.in/shadow-dom");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

         //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "#shadow-root";
        Thread.sleep(1000);
         SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
         Thread.sleep(1000);
         WebElement sh=  shadow.findElement(By.cssSelector("#shadow-element"));
         System.out.println(sh.getText());


        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost2 = "#shadow-root";
        String cssSelectorForHost3 = "#inner-shadow-dom";
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        WebElement sh2= shadow1.findElement(By.cssSelector("#nested-shadow-element"));
        System.out.println(sh2.getText());


        //This Element is inside 3 nested shadow DOM.
        String cssSelectorForHost4 = "#shadow-root";
        String cssSelectorForHost5 = "#inner-shadow-dom";
        String cssSelectorForHost6 = "#nested-shadow-dom";
        Thread.sleep(1000);
        SearchContext shadow2 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow3 = shadow2.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow4 = shadow3.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        WebElement sh4 =shadow4.findElement(By.cssSelector("#multi-nested-shadow-element"));
        System.out.println(sh4.getText());

    }

}
