package componentesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.CampoTreinamentoPage;
import util.BaseTest;
import util.DriverFactory;
import util.UtilReuso;

public class CamposTreinamentoTest extends BaseTest {

	private UtilReuso util;
	private CampoTreinamentoPage page;

	@Before
	public void iniciar() {
//		String caminho  = "D:\\" + System.getProperty("user.dir") + "\\src\\test\\resources\\componentes.html";
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizdoWagner\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver",
				"D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizdoWagner\\drivers\\chromedriver.exe");
		util = new UtilReuso();
		page = new CampoTreinamentoPage();
		DriverFactory.getDriver().get(url);
	}

	@Test
	public void campoTreinamentoTest() {
		// AÇÂO
		page.setNome("Ines");
		page.setSobrenome("Melo");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaPizza();
		page.setEscolaridade("Especializacao");

		// VALIDAÇÂO
		assertEquals("Ines", util.retornaCampoTexto("elementosForm:nome"));
		assertEquals("Melo", util.retornaCampoTexto("elementosForm:sobrenome"));
		assertTrue(util.retornaRadioCombo("elementosForm:sexo:0"));
		assertTrue(util.retornaRadioCombo("elementosForm:comidaFavorita:0"));
		assertTrue(util.retornaRadioCombo("elementosForm:comidaFavorita:2"));
		assertTrue(util.retornaOpcaoCombo("elementosForm:escolaridade", "Especializacao"));
	}

	@Test
	public void verificaValoresComboBox() {
		page.setEscolaridade("Mestrado");
		assertTrue(util.retornaOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}

	// testando uma combo box com multiplas seleções
	@Test
	public void verificaVariosValoresCombo() {
		page.setEsporte("Natacao", "Futebol", "Karate");
		List<String> marcados = util.retornaCombo("elementosForm:esportes");
		assertEquals(3, marcados.size());
	}

	// testando um caixa de texto com varias linhas
	@Test
	public void verificandoTextArea() {
		page.setSugestao("Ass Ines");
		assertEquals("Ass Ines", util.retornaCampoTexto("elementosForm:sugestoes"));
	}

	// testando um botao
	@Test
	public void verificandoBotao() {
		page.botaoCliqueAquiPage();
		assertEquals("Obrigado!", util.retornaCampoTexto("buttonSimple"));
		// assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	public void verificandoLink() {
		page.linkVoltarPage();
		assertEquals("Voltou!", page.obterResultadoCadastro());
	}

	@Test
	public void VerificandoTextoBody() {
		assertEquals("Campo de Treinamento", util.obtemTexto(By.tagName("h3")));
		assertEquals("Cuidado onde clica, muitas armadilhas...", util.obtemTexto(By.className("facilAchar")));
	}

	// verificando mensagem de Alerta simples
	@Test
	public void mensagemAlertaSimples() {
		page.botaoAlertPage();
		util.alertaAceita();
		page.setNome("Alerta simples");
		assertEquals("Alerta simples", util.retornaCampoTexto("elementosForm:nome"));
	}

	// verificando mensagem de Alerta para escolher
	@Test
	public void msgAlertaConfirma() {
		page.botaoConfirmPage();

		// confirmando mensagem de alerta
		assertEquals("Confirm Simples", util.alertaAceita());
//		Alert msg = driver.switchTo().alert();
//		assertEquals("Confirm Simples", msg.getText());
//		msg.accept();
		assertEquals("Confirmado", util.alertaAceita());
//		assertEquals("Confirmado", msg.getText());
//		msg.accept();

		// negando mensagem de alerta
		page.botaoConfirmPage();
//		driver.findElement(By.id("confirm")).click();	
		assertEquals("Confirm Simples", util.alertaNegado());
//		assertEquals("Confirm Simples", msg.getText());
//		msg.dismiss();
		assertEquals("Negado", util.alertaAceita());
//		util.alertaAceita();
//		assertEquals("Negado", msg.getText());
//		msg.accept();
	}

	// verificando mensagem de Prompt
	@Test
	public void msgAlertaDigitando() {
		page.botaoPromptPage();
//		driver.findElement(By.id("prompt")).click(); 
//		Alert alerta = driver.switchTo().alert();
		assertEquals("Digite um numero", util.msgAlerta());
		util.alertaEscreve("35");
//		assertEquals("Digite um numero", alerta.getText());
//		alerta.sendKeys("35");
//		alerta.accept();		
		assertEquals("Era 35?", util.alertaAceita());
//		assertEquals("Era 35?", alerta.getText());
//		alerta.accept();		
		assertEquals(":D", util.alertaAceita());
//		assertEquals(":D", alerta.getText());
	}

	@Test
	public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("alert('Testando js via selenium')"); // cria uma janela no frontEnd
		util.alertaAceita();
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrita via js Selenium'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

		WebElement elemento = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", elemento, "solid 4px blue");
	}

	@Test
	public void deveClicarBotaoTabela() {
		
		//*[@id='elementosForm:tableUsuarios']/tbody/tr[2]/td[3]
		// encontra a tabela
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		
		//encontar indice da coluna
		List<WebElement> coluna = tabela.findElements(By.xpath("./thead/th"));
		int idColuna = 0;
		for (int c = 0; c < coluna.size(); c++) {
			if (coluna.get(c).getText().equals("Nome")) {
				idColuna = c + 1;
				break;
			}
		}
		
		//encontra indice da linha
		List<WebElement> linha = tabela.findElements(By.xpath("./tbody/tr/td[3]"));
		int idLinha = 0;
		for (int l = 0; l < linha.size(); l++) {
			if (linha.get(l).getText().equals("Maria")) {
				idLinha = l + 1;
//				break;
			}
		}
			
		//encontrar coluna do Botao
		List<WebElement> colunaBotao = tabela.findElements(By.xpath("./thead/th"));
		int idBotao = 0;
		for (int c = 0; c < coluna.size(); c++) {
			if (coluna.get(c).getText().equals("Botao")) {
				idBotao = c + 1;
//				break;
			}
		}
		
		//clicar na celula do botao
		WebElement botao = tabela.findElement(By.xpath("/tbody/tr["+idLinha+"]/td["+idBotao+"]"));
		botao.click();
	}
}
