package Testing;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserInitiation.OpenBrowser;

public class TestExecutions extends OpenBrowser {
	
	
  @Test
  public void TestCase1() throws IOException, InterruptedException {
	  ScriptCode S = new ScriptCode();
	  S.login();
	  S.addEmployee();
	  S.EditEmployee();
	  S.DeleteEmployee();
	  S.DeleteAll();
	  
  }
}
