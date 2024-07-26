package Testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class ScriptCode extends MethodReuse {

	public void login() throws InterruptedException {
		xp("XUSR").sendKeys("selenium");
		xp("XPWD").sendKeys("selenium");
		xp("XLGN").click();
		t(2);
	}
	
	public void addEmployee() throws IOException, InterruptedException {
		
		FileInputStream fis2 = new FileInputStream("C:\\Users\\D Pavan Kumar\\eclipse-workspace\\OrangeHRM\\target\\Employees Data.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fis2);
		XSSFSheet sht=w.getSheet("New Employees");
		
		for(int i=1;i<=sht.getLastRowNum();i++) {
		A.moveToElement(xp("XPIM")).perform();
		t(1);
		xp("XADD").click();
		t(1);
		D.switchTo().frame(xp("XFRME"));
		
		int a=(int)sht.getRow(i).getCell(0).getNumericCellValue();
		xp("XCODE").clear();
		xp("XCODE").sendKeys(String.valueOf(a));
		
		for(int j=1;j<=4;j++) {
		String b= sht.getRow(i).getCell(j).getStringCellValue();
		xp("XPA"+j).sendKeys(b);
		
		if(j==1) {
			A.moveToElement(xp("XCHSE")).click().perform();
			StringSelection SS=new StringSelection("C:\\Users\\D Pavan Kumar\\Desktop\\docs\\"+b+".jpg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS,null);  //copy 
            t(2);
		    
			R.keyPress(KeyEvent.VK_CONTROL);
			R.keyPress(KeyEvent.VK_V);
			R.keyRelease(KeyEvent.VK_V);
			R.keyRelease(KeyEvent.VK_CONTROL);
			t(1);

			R.keyPress(KeyEvent.VK_ENTER);
			R.keyRelease(KeyEvent.VK_ENTER);

			}
		}
		
		t(2);
		xp("XSVE").click();
		t(1);
		xp("XBCK").click();
		D.switchTo().defaultContent();
		}
		
		t(2);
    	xp("XLGOT").click();
    	t(1);
	}

	public void EditEmployee() throws IOException, InterruptedException {
		
		FileInputStream fis2 = new FileInputStream("C:\\Users\\D Pavan Kumar\\eclipse-workspace\\OrangeHRM\\target\\Employees Data.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fis2);
		XSSFSheet sht=w.getSheet("Names to Edit");
		
		
		D.switchTo().frame(xp("XFRME"));
		for(int i=1;i<=4;i++) {
	    String a= sht.getRow(i).getCell(2).getStringCellValue();	
		xp("XEMP"+i).click();
		xp("XEDT").click();
		xp("XPA3").clear();
		xp("XPA3").sendKeys(a);
		xp("XEDT").click();
		t(1);
		xp("XBCK").click();
		}
		D.switchTo().defaultContent();
	}
	
	public void DeleteEmployee() {
		
		D.switchTo().frame(xp("XFRME"));
		for(int i=6;i<=9;i++) {
		xp("XEMP"+i).click();
		xp("XDEL").click();
		}
		}
	
    public void DeleteAll() throws InterruptedException {
    	D.switchTo().frame(xp("XFRME"));
    	xp("XSelAll").click();
    	xp("XDEL").click();
    	D.switchTo().defaultContent();
    	t(2);
    	xp("XLGOT").click();
    	t(1);
	}
}
