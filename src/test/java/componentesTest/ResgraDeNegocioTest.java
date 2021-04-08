package componentesTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.DriverFactory;
import util.UtilReuso;

public class ResgraDeNegocioTest {
	
	private UtilReuso util;
	
	@Before
	public void iniciar() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromedriver.exe");
		util = new UtilReuso();
		DriverFactory.getDriver().get(url);
	}
	
	@After
	public void finalizar() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void cadastroNomeVazio() {
		util.clicarBotao("elementosForm:cadastrar");
//		String alerta = driver.switchTo().alert().getText();
		assertEquals("Nome eh obrigatorio", util.alertaAceita());
//		driver.switchTo().alert().accept();
	}
	
	@Test
	public void cadastroSobrenomeVazio() {
		util.campoTexto("elementosForm:nome", "Ines");
		util.clicarBotao("elementosForm:cadastrar");		
//		String alerta = driver.switchTo().alert().getText();
		assertEquals("Sobrenome eh obrigatorio", util.alertaAceita());
//		driver.switchTo().alert().accept();
	}
	
	@Test
	public void cadastroSexoVazio() {
		util.campoTexto("elementosForm:nome", "Ines");
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ines");
		util.campoTexto("elementosForm:sobrenome", "Melo");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Melo");
		util.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		util.alertaAceita();
//		String alerta = driver.switchTo().alert().getText();
		assertEquals("Sexo eh obrigatorio", util.msgAlerta());
//		driver.switchTo().alert().accept();
	}
	
	@Test
	public void cadastroComidaDivergente() {
		util.campoTexto("elementosForm:nome", "Ines");
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ines");
		util.campoTexto("elementosForm:sobrenome", "Melo");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Melo");
		util.campoRadioCombo("elementosForm:sexo:1");
//		driver.findElement(By.id("elementosForm:sexo:1")).click();
		util.campoRadioCombo("elementosForm:comidaFavorita:0");
		util.campoRadioCombo("elementosForm:comidaFavorita:3");
//		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		util.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		assertEquals("Tem certeza que voce eh vegetariano?", util.alertaAceita());
//		String alerta = driver.switchTo().alert().getText();
//		assertEquals("Tem certeza que voce eh vegetariano?", alerta);
	}
	
	@Test
	public void cadastrarEsporteDivergente() {
		util.campoTexto("elementosForm:nome", "Ines");
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ines");
		util.campoTexto("elementosForm:sobrenome", "Melo");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Melo");
		util.campoRadioCombo("elementosForm:sexo:1");
//		driver.findElement(By.id("elementosForm:sexo:1")).click();
		util.campoRadioCombo("elementosForm:comidaFavorita:0");
//		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		util.campoRadioCombo("elementosForm:comidaFavorita:2");
//		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		util.campoIndex("elementosForm:escolaridade", 5);
//		Select comboEscola = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
//		comboEscola.selectByIndex(5);
		assertEquals(true, util.retornaIndex("elementosForm:escolaridade", 5));
		util.campoIndex("elementosForm:esportes", 0);
		util.campoIndex("elementosForm:esportes", 4);
//		WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
//		Select comboEsporte = new Select(esporte);
//		comboEsporte.selectByIndex(0);
//		comboEsporte.selectByIndex(4);
//		comboEsporte.getAllSelectedOptions();
		util.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		assertEquals("Voce faz esporte ou nao?", util.alertaAceita());
//		String alerta = driver.switchTo().alert().getText();
//		assertEquals("Voce faz esporte ou nao?", alerta);		
	}

}
