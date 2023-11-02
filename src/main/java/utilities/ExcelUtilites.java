package utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilites {

	
    public static String getCellValue(String filePath, String sheetName, int rowNum, int colNum) 
    
    
    {
    	
    	
    	
        String cellValue = null;
        try {
            // Open the Excel file for reading
            FileInputStream fis = new FileInputStream(filePath);

            // Load the workbook
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the specified sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            // Get the specified row
            Row row = sheet.getRow(rowNum);

            // Get the specified cell
            Cell cell = row.getCell(colNum);

            // Check if the cell is not null
            if (cell != null) {
                cellValue = cell.toString();
            }

            // Close the FileInputStream
            fis.close();
        } 
        catch (IOException e) 
        
        {
            e.printStackTrace();
        }
        return cellValue;
        
    }
}
