package UdmeyCourse.CaptureScreenShotHandleSSLBlockADsChromeExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--headless=new");  // setting for headless mode of execution
		WebDriver driver=new EdgeDriver(options);
			       
		driver.get("https://www.dummyticket.com/");
				
		String act_title=driver.getTitle();
		
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	
		driver.quit();
		
		
	}

	
}





