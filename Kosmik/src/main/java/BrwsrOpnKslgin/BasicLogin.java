package BrwsrOpnKslgin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BasicLogin {
	
	public static WebDriver D;
	public static Properties P;
	public static Actions A;
	public static Robot R;
	public static Select S;
	public static StringSelection SS;
	public static Alert Alt;
	
	
	
   @BeforeMethod
  public void beforeMethod() throws AWTException, IOException {
	  
	  System.setProperty("webdriver.chrome.drive", "C:\\Users\\D Pavan Kumar\\eclipse-workspace\\Kosmik\\src\\main\\chromedriver.exe");
	  D=new ChromeDriver();
	  D.manage().window().maximize();
	  
	  A=new Actions(D);
      R=new Robot();
      
      FileInputStream fis1=new FileInputStream("C:\\Users\\D Pavan Kumar\\eclipse-workspace\\Kosmik\\src\\data\\java\\DataFile");
	  P=new Properties();
	  P.load(fis1);
		
	  D.get(P.getProperty("URL"));
	  
  }


@AfterMethod
  public void afterMethod() {
	
  }

}
