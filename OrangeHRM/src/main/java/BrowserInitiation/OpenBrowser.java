package BrowserInitiation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class OpenBrowser {
	
	public static WebDriver D;
	public static Properties P;
	public static Actions A;
	public static Robot R;
	
   @BeforeMethod
  public void beforeMethod() throws IOException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\D Pavan Kumar\\eclipse-workspace\\OrangeHRM\\target\\chromedriver.exe");
	 D = new ChromeDriver();
	 D.manage().window().maximize();
	 
	 FileInputStream fis1=new FileInputStream("C:\\Users\\D Pavan Kumar\\eclipse-workspace\\OrangeHRM\\src\\data\\java\\Data File");
	 P=new Properties();
	 P.load(fis1);
	 D.get(P.getProperty("URL"));
	 
	 A=new Actions(D);
	 R=new Robot();
		
	 
	 }

  @AfterMethod
  public void afterMethod() {
	   D.quit();
  }

}
