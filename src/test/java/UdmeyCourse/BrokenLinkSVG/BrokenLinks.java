package UdmeyCourse.BrokenLinkSVG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.orangehrm.com/en/solutions/people-management");
        driver.manage().window().maximize();
        driver.navigate().refresh();

        List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println("Number of link " + link.size());
       int Numberofbrokenlink=0;
        for (WebElement links : link) {
            String Allhrefvalue = links.getAttribute("href");
            System.out.println("Display the all url" +Allhrefvalue);
            if (Allhrefvalue == null || Allhrefvalue.isEmpty()) {
                System.out.println("Link not open");
                continue;
            }
            try {
                URL url = new URL(Allhrefvalue);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() >= 400) {
                    System.out.println("Link opened");
                    Numberofbrokenlink++;
                } else {
                    System.out.println("Link not Open");
                }
            } catch (Exception e)
            {
            }
            System.out.println("Link opened" +Numberofbrokenlink);
            //driver.quit();

        }}
}