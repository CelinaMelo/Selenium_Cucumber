package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName nome = new TestName();
	
	@After
	public void finaliar() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target\\file\\" + nome.getMethodName() + ".jpg")); 
		
		if (Browser.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}
}
