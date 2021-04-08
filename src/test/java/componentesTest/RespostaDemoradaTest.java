package componentesTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverFactory;
import util.UtilReuso;

public class RespostaDemoradaTest {
	
	private UtilReuso util;
	
	@Before
	public void iniciando() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webDriverFactory.getDriver().chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromeDriverFactory.getDriver().exe");
		util = new UtilReuso();
		DriverFactory.getDriver().get(url);
	}
	
	@After
	public void finalizando() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void sincronismoEsperaFixa() throws InterruptedException {
		util.clicarBotao("buttonDelay");
		Thread.sleep(3000);
		util.campoTexto("novoCampo", "Testando");
	}

	@Test
	public void sincrniscmoEsperaImplicita() {
		util.clicarBotao("buttonDelay");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		util.campoTexto("novoCampo", "Testando");
	}
	
	@Test
	public void sincrniscmoEsperaExplicita() {
		util.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		util.campoTexto("novoCampo", "Testando");
	}
	
	@Test
	public void testAjax() {
		String url = "https://www.primefaces.org/showcase/ui/ajax/basic.xhtml";
		DriverFactory.getDriver().get(url);
		util.campoTexto("j_idt727:name", "Testando");
		util.clicarBotao("j_idt727:j_idt730");		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt727:display"), "Testando"));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt807_start")));
		assertEquals("Testando", util.obtemTexto("j_idt727:display"));
	}

}
