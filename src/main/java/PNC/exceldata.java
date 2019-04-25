package PNC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class exceldata {

	@DataProvider(name = "flipkartdata")
	public static ArrayList<String> retrivedata() throws IOException {
		FileInputStream ff = new FileInputStream("E:\\VANI\\Flipkart.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ff);

		ArrayList<String> search = new ArrayList<String>();

		// int i = 0;
		// int i = workbook.getNumberOfSheets();
		// System.out.println(i);
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
		Iterator<Row> r = worksheet.rowIterator();

		r.next();
		Row secondrow = r.next();

		Cell name = secondrow.getCell(0);
		Iterator<Cell> c = secondrow.cellIterator();
		// Cell Name = c.next();

//System.out.println(name.getStringCellValue());
		if (name.getStringCellValue().equalsIgnoreCase("Gopi")) {

			while (c.hasNext()) {
				// Cell cell = (Cell) c.next();
				Cell cc = c.next();
				// System.out.println(cc);
				search.add(cc.getStringCellValue());
				System.out.println(search);
				// i++;

			}

		}

		// System.out.println(search);
		return search;

	}

}
