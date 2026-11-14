package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Excel-Workbook-Sheets-rows-cells
		
		FileInputStream file = new FileInputStream("C:\\HybridAutomationFramework\\testdata\\Tesdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(1).getLastCellNum();
		
		
		System.out.println("Number of rows :" +row);   //10
		System.out.println("num of cells :" +cell);   //5
		
		for(int r = 0;r<=row;r++) {
			
			XSSFRow Crow = sheet.getRow(r);
			
			for(int c=0;c<cell;c++) {
				
				XSSFCell Ccell = Crow.getCell(c);
				
				System.out.print(Ccell.toString()+ "\t");
				
			}
			System.out.println();
		}
		
		
		workbook.close();
		file.close();

	}

}
