package componentesTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.CampoTreinamentoPage;
import util.DriverFactory;

public class CadastroCompletoTest {
	private CampoTreinamentoPage page;
	
	@Before
	public void iniciando() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromedriver.exe");
		DriverFactory.getDriver().get(url);
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finalizando() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void cadastroCompleto() {
		page.setNome("Ines");
		page.setSobrenome("Melo");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaPizza();
		page.setEscolaridade("Especializacao");
		page.setEsporte("Natacao");
		page.setSugestao("Estamos contando com vc!");	
		
		page.botaoCadastrarPage();
		
		assertEquals("Cadastrado!", page.obterResultadoCadastro());
		assertEquals("Ines", page.obterNomeCadastro());
		assertEquals("Melo", page.obterSobrenomeCadastro());
		assertEquals("Feminino", page.obterSexoCadastro());
		assertEquals("Carne Pizza", page.obterComidaCadastro());
		assertEquals("especializacao", page.obterEscolaridadeCadastro());
		assertEquals("Natacao", page.obterEsporteCadastro());
	}
	
}
