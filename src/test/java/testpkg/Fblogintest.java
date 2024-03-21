package testpkg;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.Fbloginpage;
import utilities.Excelutilis;

public class Fblogintest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
	
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	}
	
	@Test
	public void verifyLoginwithValidCred () 
	{
		Fbloginpage p1 = new Fbloginpage(driver);
		
		//Reading the data from excel file by the specified path
		
		String xl = "C:\\Users\\AMAL JOSE\\OneDrive\\Documents\\fblogin.xlsx";
		String sheet = "Sheet1";
		int rowcount = Excelutilis.rowCount(xl,sheet);
		for (int i=1;i<=rowcount;i++)
		{
			String Username=Excelutilis.getCellValue(xl,sheet,i,0);
			System.out.println("Username is"+Username);
			
			String Pwd=Excelutilis.getCellValue(xl,sheet,i,1);
			System.out.println("Password is"+Pwd);
			//passing username and password as parameters
			p1.setvalues(Username, Pwd);
			//submitting the data by clicking on login button
			p1.loginclick();
					
		}
	}

}
