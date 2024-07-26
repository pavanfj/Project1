package Testing;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import BrwsrOpnKslgin.BasicLogin;

public class TestCase1 extends BasicLogin {
	
	
  @Test
  public void sftTesting() throws IOException, InterruptedException, AWTException {
	  
	  Script S=new Script();
	  S.login();
	 // S.Edit();
	 S.registration();
	  
  }
}
