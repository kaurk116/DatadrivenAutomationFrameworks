package UdmeyCourse.CaptureScreenShotHandleSSLBlockADsChromeExtension;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v141.page.model.Screenshot;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.time.Duration;

public class TakeScreenshot {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        /*TakesScreenshot ts = (TakesScreenshot)driver;
        File Sourcefile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
        Sourcefile.renameTo(targetFile);*/

        //2) capture the screenshot of specific section
		/*WebElement featuredProducts=driver.findElement(By.xpath("//div[@aria-label='2 / 2']//img[@class='slider-img']"));
		File sourcefile=featuredProducts.getScreenshotAs(OutputType.FILE);
	    File targetfile=new File(System.getProperty("user.dir")+"\\Screenshots\\featredproducts.png");
		sourcefile.renameTo(targetfile); // copy sourcefile to target file*/


        //3) capture the screenshot of webelement
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourcefile=logo.getScreenshotAs(OutputType.FILE);
        File targetfile=new File(System.getProperty("user.dir")+"/Screenshot/logo.png");   //not working
        sourcefile.renameTo(targetfile); // copy sourcefile to target file
        driver.quit();
    }
}
