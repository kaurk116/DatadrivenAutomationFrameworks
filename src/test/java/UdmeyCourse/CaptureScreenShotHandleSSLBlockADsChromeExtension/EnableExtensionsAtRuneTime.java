package UdmeyCourse.CaptureScreenShotHandleSSLBlockADsChromeExtension;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.HasDownloads;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EnableExtensionsAtRuneTime {

public static void main(String[] args) {
	EdgeOptions options =new EdgeOptions();
	File file=new File("/home/karam/Documents/Projects/DatadrivenAutomationFramework/Screenshot/SelectorsHub.crx");
	options.addExtensions(file);
	WebDriver driver=new EdgeDriver(options);
	driver.get("https://text-compare.com/");
    }
}
