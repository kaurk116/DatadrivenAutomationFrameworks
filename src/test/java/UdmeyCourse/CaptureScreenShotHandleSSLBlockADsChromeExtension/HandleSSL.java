package UdmeyCourse.CaptureScreenShotHandleSSLBlockADsChromeExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		
		EdgeOptions options=new EdgeOptions();
		options.setAcceptInsecureCerts(true); // accepts SSL certificates
		WebDriver driver=new EdgeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println("title of the page:"+driver.getTitle()); //Privacy error
																	//expired.badssl.com
				
	}

}
