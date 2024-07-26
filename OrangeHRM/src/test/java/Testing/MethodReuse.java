package Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MethodReuse extends TestExecutions {

	public WebElement xp(String a) {
		return D.findElement(By.xpath(P.getProperty(a)));
		}
	
	public void t(int a) throws InterruptedException {
		Thread.sleep(a*1000);
	}
	
	
	
}
