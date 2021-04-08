package componentesTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.CampoTreinamentoPage;
import util.DriverFactory;
import util.UtilReuso;

public class CadastroFrameTest {
	
	private UtilReuso util;
	private CampoTreinamentoPage page;
	
	@Before
	public void iniciar() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromedriver.exe");
		util = new UtilReuso();
		page = new CampoTreinamentoPage();
		DriverFactory.getDriver().get(url);
	}
	
	@After
	public void finalizar() {
		DriverFactory.getDriver().quit();
	}
	
	@Test
	public void comecandoFrame() {
		util.entrarFramer("frame1");
		page.botaoDentroFramePage();	
		String msg = util.alertaAceita();
		assertEquals("Frame OK!", msg);
		util.sairFramer();
		util.campoTexto("elementosForm:nome", msg);	
	}
	
	@Test
	public void abrindoFrameEscondido() {
//		WebElement js = driver.findElement(By.id("frame2"));
//		util.executarJS("window.scrollBy(0, arguments[0]", js.getLocation().y);
		
		util.entrarFramer("frame2");
		util.clicarBotao("frameButton");
		String msg = util.alertaAceita();
		assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void abrindoPouUpComNome() {
		page.botaoAbrirPopupPage();
//		driver.findElement(By.id("buttonPopUpEasy")).click();
		util.trocarJanelaFramer("Popup");
		util.campoTexto(By.tagName("textarea"), "Deu certo?");
//		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		DriverFactory.getDriver().close();
		util.trocarJanelaFramer("");
//		driver.switchTo().window("");
		util.campoTexto("elementosForm:sugestoes", "elementosForm:sugestoes");
//		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("E agora?");
		
	}
	
	@Test
	public void abrindoPopUpSemNome() {
		util.clicarBotao("buttonPopUpHard");
//		System.out.println(driver.getWindowHandle());
//		System.out.println(driver.getWindowHandles());
		util.trocarJanelaFramer((String) DriverFactory.getDriver().getWindowHandles().toArray()[1]);
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		util.campoTexto(By.tagName("textarea"), "Consegui?");
//		driver.findElement(By.tagName("textarea")).sendKeys("Consegui?");
		DriverFactory.getDriver().close();
		util.trocarJanelaFramer((String) DriverFactory.getDriver().getWindowHandles().toArray()[0]);
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		util.campoTexto("elementosForm:sugestoes", "E agora!?");
	}

}
