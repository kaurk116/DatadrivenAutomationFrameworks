package UdmeyCourse.Day22.Table.DynamicTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootStrapTable_Orangehrm {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'viewAdminModule')]")).click();
        int No_of_rows= driver.findElements(By.xpath("//div[@class='oxd-table-body']/div")).size();
        System.out.println(No_of_rows);

        for (int r = 1; r <No_of_rows ; r++) {
            String name =driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[@class=\"oxd-table-card\"]["+r+"]/div/div[2]/div")).getText();
            String userole=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[3]//div")).getText();
            String employeename=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[4]//div")).getText();
            String status=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[5]//div")).getText();
            System.out.println(name+ "/t" +userole+ "/t" +employeename+ "/t" +status) ;


        }
    }
}
