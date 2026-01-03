package UdmeyCourse.Day22.Table.DynamicTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.text;

public class PaginationTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // driver.findElement(By.xpath("//a[normalize-space()="+2+"]")).click();
        //driver.findElement(By.xpath("//a[normalize-space()="+3+"]")).click();

        //repeating pages
        int pageNo = driver.findElements(By.xpath("(//ul[@id='pagination'])//li//a")).size();
      System.out.println("Number of pages" +pageNo);
        for (int p = 1; p <= pageNo; p++) {
            if (p > 1) {
                WebElement active_page = driver.findElement(By.xpath("//a[normalize-space()=" + p + "]"));
                active_page.click();
                Thread.sleep(3000);
            }
                 int row = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr")).size();
            System.out.println(row);
            for (int i = 1; i < row+1; i++) {
                String lll =driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+i+"]//td[2]")).getText();
                WebElement checkBoxElement = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td//input[@type=\"checkbox\"]"));
                System.out.println(lll);
                if (!checkBoxElement.isSelected()) {
                    checkBoxElement.click();
                }

            }

                }

                }
            }

