package PNC;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipkartTest extends baseTest{
	
	baseTest bs;
	
	public FlipkartTest() throws IOException
	{
	WebDriver driver = bs.getdata(); 	
	}
	
	
	@Parameters({"URL"})
	@Test
	public void searchproduct(String value)
	{
		
		driver.get(value);
		System.out.println("Test");
		
		
		
	}

}
