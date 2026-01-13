package UdmeyCourse.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class blaze_demo_table {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Choose your departure city:
        WebElement departure_city = driver.findElement(By.xpath("//select[@name='fromPort']"));
        departure_city.click();
        Select city = new Select(departure_city);
        city.selectByValue("Paris");

        //Choose your destination city:
        WebElement destination_city = driver.findElement(By.xpath("//select[@name='toPort']"));
        destination_city.click();
        Select city2 = new Select(destination_city);
        city2.selectByValue("London");


        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
        int cols = driver.findElements(By.xpath("//table[@class='table']//tbody//th")).size();

        System.out.println(rows);
        System.out.println(cols);
       /*for(int r=2;r<=rows;r++) {
           for (int c = 1; c <= cols; c++) {
               String table_data = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]//td[" + c + "]")).getText();
               System.out.println(table_data);
           }*/
        String arr_price[] = new String[rows];
        for (int r = 1; r < rows; r++) {
            String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]/td[6]")).getText();
            arr_price[r - 1] = price;
        }
        for (String arrvalue : arr_price) {
            System.out.println(arrvalue);
        }try {
            Arrays.sort(arr_price);
        } catch (NullPointerException e) {
        }
       // Arrays.sort(arr_price); // this will be able to sort strings. so no need to convert to number
        String lowestPrice = arr_price[0];
        System.out.println("Lower price:" + lowestPrice);

        // Find record in table having lower price

        for (int r = 1; r <= rows; r++) {
            String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]/td[6]")).getText();
            System.out.println("price is now:" + price);
            Thread.sleep(5000);
            if (price.equals(lowestPrice)) {
                driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]/td[1]//input")).click();
                break;
            }
        }
            //9 - Fill the details then click on Purchase Flight button
            Thread.sleep(5000);
            driver.findElement(By.id("inputName")).sendKeys("John");
            driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
            driver.findElement(By.id("city")).sendKeys("Columbus");
            driver.findElement(By.id("state")).sendKeys("OH");
            driver.findElement(By.id("zipCode")).sendKeys("43240");
            driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
            driver.findElement(By.id("creditCardYear")).clear();
            driver.findElement(By.id("creditCardYear")).sendKeys("2023");
            driver.findElement(By.id("nameOnCard")).sendKeys("John Canedy");
            driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

            //10 - validation
            String msg=driver.findElement(By.xpath("//h1")).getText();

            if(msg.contains("Thank you for your purchase"))
            {
                System.out.println("Success !! Passed");
            }
            else
            {
                System.out.println("Failed");
            }

            driver.quit();
    }
}
