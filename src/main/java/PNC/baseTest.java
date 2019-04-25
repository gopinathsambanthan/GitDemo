package PNC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class baseTest {
	
	WebDriver driver;
	
	@Test(dataProvider = "retrivedata")
	public void sample(String search) throws IOException
	{
		
		System.out.println("Sysso");
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gopinath\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		System.out.println("reachedpoint");
		
		driver.findElement(By.id("//input[@type='text']")).sendKeys(search);
		//System.out.println(exceldata.retrivedata());
		
	}
	
	@DataProvider()
	public  String[] retrivedata() throws IOException {
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
		
		String[] s = new String[20];
for (int i = 0; i < search.size(); i++) {
	
	s[i]= search.get(i);
	
}
		// System.out.println(search);
		return s;

	}
	
	public WebDriver getdata() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream ff = new FileInputStream("C:\\Users\\gopinath\\MavenProject\\Data.properties");
		
		prop.load(ff);
		
	if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gopinath\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
	}
	
	else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
		System.out.println("i am not here");
		
	}
	
	else if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
		
		System.out.println("i am not here");
	}
	return driver;
		
	}
	
	

}
