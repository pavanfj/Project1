package Testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Script extends MethodReuse 
{
	
	
	public void login() {
	xp("XUN").sendKeys("kosmik");
	xp("XPWD").sendKeys("kosmik");
	xp("XSBMT").click();
	}
	
	public void registration() throws IOException, InterruptedException, AWTException {
		
		FileInputStream fis2=new FileInputStream("C:\\Users\\D Pavan Kumar\\Desktop\\my finance.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fis2);
		XSSFSheet sht1=w.getSheet("TestSample4");
		xp("XRGSTR").click();
		
		
		for (int i=1;i<=sht1.getLastRowNum();i++)  {
			
			dropDown("XPACA1","Self");
			dropDown("XPATID","AAdhar Card");
		    for (int j=0; j<=12;j++)  {
		   String v=sht1.getRow(i).getCell(j).getStringCellValue(); //dd
		     dropDown("XPA"+j,v);
		}
		    
		    for(int j=13; j<=20; j++)  {
		   String v=sht1.getRow(i).getCell(j).getStringCellValue(); //dd
		   xp("XPA"+j).sendKeys(v);
		   
		      if(j==13) {
			   A.moveToElement(xp("XCHSE")).click().perform();
				StringSelection SS=new StringSelection("C:\\Users\\D Pavan Kumar\\Desktop\\docs\\"+v+".jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS,null);  //copy 
				t(2);

		        R.keyPress(KeyEvent.VK_CONTROL);
				R.keyPress(KeyEvent.VK_V);
				R.keyRelease(KeyEvent.VK_V);
				R.keyRelease(KeyEvent.VK_CONTROL);
				t(2);
				R.keyPress(KeyEvent.VK_ENTER);
				R.keyRelease(KeyEvent.VK_ENTER);
		                }
	    }
		    
		    dropDown("XCNTRY","America");
		    
		    for(int j=21; j<=23; j++)  {
				   long v=(long)sht1.getRow(i).getCell(j).getNumericCellValue(); //dd
				   xp("XPA"+j).sendKeys(String.valueOf(v));
			         }
		    xp("XSVE").click();
		    t(1);
		    Alt=D.switchTo().alert()	;
			Alt.accept();
		}}
	
	
	
    public void Edit () throws InterruptedException, AWTException, IOException  {
    	
    	
        FileInputStream fis2=new FileInputStream("C:\\Users\\D Pavan Kumar\\Desktop\\my finance.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fis2);
		XSSFSheet sht1=w.getSheet("TestSample4");
		
		xp("XRGLST").click();
    	t(1);
    	xp("XPRGLST").click();
    	t(1);
		
		for (int i=1;i<=sht1.getLastRowNum();i++) { 
			
    	xp("XPEDT"+i).click();
    	
    	dropDown("XPACA2","Self");
		dropDown("XPATID","AAdhar Card");
		
	    for (int j=0; j<=12;j++)  {
	   String v=sht1.getRow(i).getCell(j).getStringCellValue(); //dd
	     dropDown ("XPA"+j, v);
	}
	    
	    for(int j=13; j<=20; j++)  {
	   String v=sht1.getRow(i).getCell(j).getStringCellValue();  //dd
	   xp("XPA"+j).clear();
	   xp("XPA"+j).sendKeys(v);
	   
	      if(j==13) {
		   A.moveToElement(xp("XCHSE")).click().perform();
			StringSelection SS=new StringSelection("C:\\Users\\D Pavan Kumar\\Desktop\\docs\\"+v+".jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS,null);  //copy 
			t(2);

			Robot R=new Robot();

			R.keyPress(KeyEvent.VK_CONTROL);
			R.keyPress(KeyEvent.VK_V);
			R.keyRelease(KeyEvent.VK_V);
			R.keyRelease(KeyEvent.VK_CONTROL);
			t(2);
			R.keyPress(KeyEvent.VK_ENTER);
			R.keyRelease(KeyEvent.VK_ENTER);
	                }
    }
	    
	    dropDown("XCNTRY","America");
	    
	    for(int j=21; j<=23; j++)  {
			   long v=(long)sht1.getRow(i).getCell(j).getNumericCellValue(); //dd
			   xp("XPA"+j).clear();
			   xp("XPA"+j).sendKeys(String.valueOf(v));
		         }
	    xp("XSVE").click();
	    t(1);
	    Alt=D.switchTo().alert()	;
		Alt.accept();
		}
    }
}
