package UdmeyCourse.ReadExcelFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

//Excel File--->Workbook--->Sheets--->Rows----Cells
public class ReadDataFromExcel {
    public static void main(String[] args) throws IOException {
        //get file pth
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Book.xlsx");
        //Get file
        XSSFWorkbook workbook=new XSSFWorkbook(file);
       //get sheet
        XSSFSheet  sheet=workbook.getSheet("Sheet1");
        //get row number
        int total_row= sheet.getLastRowNum();
        int total_cell =sheet.getRow(0).getLastCellNum();
        //get cell number
        System.out.println("Number of row" +total_row);
        System.out.println("Number of cell in row" +total_cell);

        for (int r = 0; r <=total_row ; r++) {
            XSSFRow current_row = sheet.getRow(r);

            for (int c = 0; c < total_cell; c++) {
                XSSFCell cell = current_row.getCell(c);
                System.out.print(cell.toString() + "\t");
            }
        }
        workbook.close();
        file.close();

    }
}
