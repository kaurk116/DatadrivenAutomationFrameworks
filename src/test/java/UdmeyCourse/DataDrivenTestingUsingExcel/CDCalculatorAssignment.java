package UdmeyCourse.DataDrivenTestingUsingExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CDCalculatorAssignment {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/caldata2.xlsx";
        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
        System.out.println("row count is : " + rows);
        for (int i = 1; i <= rows; i++) {
            //ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String Deposit_Amount = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String Lendth_of_cd = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String APY = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String Componding = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String CD_worth_Value= ExcelUtils.getCellData(filePath, "Sheet1", i, 4);

            WebElement Deposit_Field =driver.findElement(By.xpath("//input[@id='mat-input-0']"));
            Deposit_Field.clear();
            Deposit_Field.sendKeys(Deposit_Amount);
            WebElement Lendth_field= driver.findElement(By.xpath("//input[@id='mat-input-1']"));
            Lendth_field.clear();
            Lendth_field.sendKeys(Lendth_of_cd);
            WebElement apy_field= driver.findElement(By.xpath("//input[@id='mat-input-2']"));
            apy_field.clear();
            apy_field.sendKeys("2");
            WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   //select class object compounddrp will find elelment by id
            compoundrp.click();

            List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));

            for(WebElement option:options)
            {
                if(option.getText().equals(Componding))
                    option.click();
            }
            driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();

            //validation
            String act_mvalue=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
            System.out.println("After calculate" +act_mvalue);
            System.out.println("From Sheet" +CD_worth_Value);



            if(act_mvalue.equals(CD_worth_Value))
            {
                System.out.println("Test passed");
                ExcelUtils.setCellData(filePath, "Sheet1",i,5,"Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1",i,5);
            }
            else
            {
                System.out.println("Test failed");
                ExcelUtils.setCellData(filePath, "Sheet1",i,5,"Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1",i,5);
            }

            Thread.sleep(3000);

        } //ending of for loop

        driver.quit();
    }
}
