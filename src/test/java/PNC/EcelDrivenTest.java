package PNC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EcelDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub a 
		System.out.println("sarted");
		
		FileInputStream fr = new FileInputStream("E:\\VANI\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fr);
		int sheets  = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet worksheet = workbook.getSheetAt(i);
				Iterator<Row> row = worksheet.iterator();
				Row r = row.next();
				Iterator<Cell> ce = r.cellIterator();	
				if (ce.hasNext())
				{
					Cell c = ce.next();
					if(c.getStringCellValue().equalsIgnoreCase("Testcase"))
					{
						System.out.println(c.getColumnIndex());
						System.out.println(c.getRowIndex());
					}
					
				}
			
			
			}
		}
		

	}

}
