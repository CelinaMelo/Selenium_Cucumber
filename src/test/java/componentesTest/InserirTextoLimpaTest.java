package componentesTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.DriverFactory;
import util.UtilReuso;

public class InserirTextoLimpaTest {
	private UtilReuso util;

	@Before
	public void iniciando() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromedriver.exe");
		util = new UtilReuso();
		DriverFactory.getDriver().get(url);
	}

	@After
	public void finalizando() {
		DriverFactory.killDriver();
	}

	@Test
	public void inserirNomeDepoisLimpa() {
		util.campoTexto("elementosForm:nome", "Ines");
		assertEquals("Ines", util.retornaCampoTexto("elementosForm:nome"));
		util.limpaTexto("elementosForm:nome");
		util.campoTexto("elementosForm:nome", "Celina");
		assertEquals("Celina", util.retornaCampoTexto("elementosForm:nome"));
	}
}
