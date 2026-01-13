package UdmeyCourse.JavaExecuter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload - Test1.txt
		//driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("/home/karam/Documents/Projects/DatadrivenAutomationFramework/src/test/java/UdmeyCourse/MouseEvent/Day-35.txt");
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(System.getProperty("user.dir")+"/Screenshot/Day-35.txt");  //working
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Day-35.txt"))
		{
			System.out.println("File is sucessfully uploaded");
		}
		else
		{
			System.out.println("Upload failed.");
		}

		
		//Multiple files uploaded
		/*String file1="C:\\Automation\\automationFiles\\Test1.txt";
		String file2="C:\\Automation\\automationFiles\\Test2.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int noOfFilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		//validation 1 - Number of files 
		if(noOfFilesUploaded==2)
		{
			System.out.println("All Files are uploaded");
		}
		else
		{
			System.out.println("Files are not uploaded or incorrect files uploaded");
		}
		
		//validate file names
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test2.txt"))
		{
			System.out.println("File names matching..");
		}
		else
		{
			System.out.println("Files are not not matching.");
		}*/
				
		
	}

}
