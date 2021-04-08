package parametrizacao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import pages.CampoTreinamentoPage;
import util.BaseTest;
import util.DriverFactory;
import util.UtilReuso;

@RunWith(Parameterized.class)
public class RegraCadastroParametrizadoTest extends BaseTest {
	
	private UtilReuso util;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public Object sexo;
	@Parameter(value = 3)
	public List<String> comida;
	@Parameter(value = 4)
	public String[] esporte;
	@Parameter(value = 5)
	public Object msg;
	
	
	@Before
	public void iniciando() {
		String url = "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\src\\test\\resources\\componentes.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Documentos Ines\\PROGRAMAÇÃO - DEV\\EclipseProjects\\TesteAutomatizadoComponentes\\drivers\\chromedriver.exe");
		util = new UtilReuso();
		page = new CampoTreinamentoPage();
		DriverFactory.getDriver().get(url);
	}
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Ines", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"Ines", "Melo", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"Ines", "Melo", "Feminino", Arrays.asList("Carne", "Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
			{"Ines", "Melo", "Masculino", Arrays.asList("Carne"), new String[] {"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"},
		});
	}
	
	@Test
	public void deveValidarRegra() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);		
		if (sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}
		if (sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}		
		if (comida.contains("Carne")) page.setComidaCarne();
		if (comida.contains("Frango")) page.setComidaFrango();
		if (comida.contains("Pizza")) page.setComidaPizza();
		if (comida.contains("Vegetariano")) page.setComidaVegetariano();		
		page.setEsporte(esporte);		
		page.botaoCadastrarPage();
		System.out.println(msg);
		assertEquals(msg, util.alertaAceita());//		
	}
}
