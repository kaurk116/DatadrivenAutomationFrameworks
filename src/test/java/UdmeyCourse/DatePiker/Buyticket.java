package UdmeyCourse.DatePiker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//Assignment

public class Buyticket {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//input[@name='source[]'])[1]")).sendKeys("Delhi");
        Thread.sleep(3000);
        List<WebElement> sugession_list = driver.findElements(By.xpath("//div[@class='suggestion-block']"));
        for (WebElement sugession_list2 : sugession_list) {
            if (sugession_list2.getText().contains("Indira Gandhi International, ")) ;
            sugession_list2.click();
            break;
        }
        driver.findElement(By.xpath("(//input[@name='destination[]'])[1]")).sendKeys("Bangalore");
        List<WebElement> tosugession = driver.findElements(By.xpath("(//ul[@class='suggestions-list'])[2]"));
        for (WebElement sugession : tosugession) {
            if (sugession.getText().contains("HAL Bangalore International Airport")) ;
            sugession.click();
            break;
        }

        //select date from dte piker
        String expected_month = "Mar";
        String expected_year = "2027";
        String expecter_date = "15";
        driver.findElement(By.xpath("//input[@placeholder=\"Departure Date\"][1]")).click();
        WebElement selectMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select month = new Select(selectMonth);
        month.selectByVisibleText(expected_month);

        WebElement selectyear = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
        Select year = new Select(selectyear);
        year.selectByVisibleText(expected_year);

        List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dt : AllDates) {
            if (dt.getText().equals(expecter_date)) {
                System.out.println(dt);
                dt.click();
                break;
            }
        }
    }
}
