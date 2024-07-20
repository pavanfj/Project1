package Testing;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScriptingCode extends MethodReuse {

	public void login() throws IOException {
		D.get(P.getProperty("URL"));
		xp("XUN").sendKeys(P.getProperty("UN"));
		xp("XPWD").sendKeys(P.getProperty("PWD"));
		xp("XL").click();
	//	photoshot("login");
	}

	public void AddEmployee() throws InterruptedException, IOException
	{
		t(2);
		
		FileInputStream fis=new FileInputStream("C:\\Users\\D Pavan Kumar\\Desktop\\my finance.xlsx");
		  
	     XSSFWorkbook w= new XSSFWorkbook(fis);
		
		XSSFSheet sht=w.getSheet("TestSample2");
		 
		  for (int i=1;i<=sht.getLastRowNum();i++)  
		{
			int eid=(int)sht.getRow(i).getCell(0).getNumericCellValue();
			String efrst=sht.getRow(i).getCell(1).getStringCellValue();
			String emid=sht.getRow(i).getCell(2).getStringCellValue();
			String elst=sht.getRow(i).getCell(3).getStringCellValue();
			String enic=sht.getRow(i).getCell(4).getStringCellValue();
			
		A.moveToElement(xp("XPIM")).perform();
		//photoshotseries(efrst+" 1", efrst);
		t(1);
		xp("XADD").click();
		t(1);
		//photoshotseries(efrst+" 2",efrst);
		D.switchTo().frame(xp("XFRME1"));
		
		  
		xp("XEID").clear();
		xp("XEID").sendKeys(String.valueOf(eid));
		xp("XLNM").sendKeys(elst);
		xp("XFNM").sendKeys(efrst);
		xp("XMNM").sendKeys(emid);
		xp("XNNM").sendKeys(enic);
		
		t(2);
		
		A.moveToElement(xp("XCHSE")).click().perform();
		SS=new StringSelection("C:\\Users\\D Pavan Kumar\\Desktop\\docs\\"+efrst+".jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS,null);
		t(2);
		
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_V);
		R.keyRelease(KeyEvent.VK_CONTROL);
		R.keyRelease(KeyEvent.VK_V);
		t(1);
		
		R.keyPress(KeyEvent.VK_ENTER);
		R.keyRelease(KeyEvent.VK_ENTER);
		t(2);
		//photoshotseries(efrst+" 3",efrst);
		
		xp("XSVE").click();
		//photoshotseries(efrst+" 4",efrst);
		
		t(2);
		
		xp("XBCK").click();
		//photoshotseries(efrst+" 5",efrst);
		D.switchTo().defaultContent();
		}
		
		}
	
	
	public void UpdateEmployee() throws IOException  {
		D.switchTo().frame(xp("XFRME1"));
		
		for(int i=1; i<=6; i++) {
			
		xp("XEMP"+i).click();
		xp("XEDT").click();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\D Pavan Kumar\\Desktop\\my finance.xlsx");
	     XSSFWorkbook w= new XSSFWorkbook(fis);
        XSSFSheet sht=w.getSheet("TestSample2");
        
        String emid=sht.getRow(i).getCell(2).getStringCellValue();
		
		xp("XMNM").clear();
		xp("XMNM").sendKeys(emid);
		xp("XSVE").click();
		xp("XBCK").click();
		
		}
		
		}
	
	public void allDelete() {
		D.switchTo().frame(xp("XFRME1"));
		xp("XECBXALL").click();
		xp("XDEL").click();
	}
	
	
	public void del1by1()  {
		D.switchTo().frame(xp("XFRME1"));
		
		for(int i=1; i<=5; i++) {
			xp("XECBX"+i).click();
			xp("XDEL").click();
		}
		}
	
	public void assignLeave() throws InterruptedException {
		
		A.moveToElement(xp("XLVE")).perform();
		xp("XASSL").click();

		D.switchTo().frame(xp("XFRME1"));
			
			xp("XEMPE1").sendKeys("Sophia Williams");
			t(1);
			A.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
			
			dropDown("XDD","LTY003");
			
			xp("XDTT1").click();
			t(1);
			String vd="August 2024";
			String v= xp("XDMY").getText();
			v=v.trim();
			System.out.println(v);
			
			    while(!(vd.equals(v))) {
				xp("XNBT").click();
				v= xp("XDMY").getText();
				v=v.trim();
				System.out.println(v);
			}
			
			xp("XFRM").click();
			
			xp("XDTT2").click();
			Thread.sleep(1000);
			xp("XTO").click();
			
			//xp("XASSBT").click();

		}
	
	

}

