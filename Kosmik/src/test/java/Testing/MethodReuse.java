package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MethodReuse extends TestCase1 {
	
	public WebElement xp(String a) {
		return D.findElement(By.xpath(P.getProperty(a)));
		}
	
	public void dropDown(String a, String b) {
		WebElement dd1=xp(a);
		S=new Select(dd1);
		S.selectByVisibleText(b);
	}
	
	public void t(int a) throws InterruptedException {
		Thread.sleep(a*1000);
	}

}
