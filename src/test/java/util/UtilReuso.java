package util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilReuso {

	// ***** TextField e TextArea *****//
	public void campoTexto(By by, String texto) {
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public void campoTexto(String id, String texto) {
		DriverFactory.getDriver().findElement(By.id(id)).clear();
		campoTexto(By.id(id), texto);
	}

	public String retornaCampoTexto(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
	}

	public void limpaTexto(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).clear();
	}

	// ***** Radio e Check *****//
	public void campoRadioCombo(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}

	public void campoIndex(String id, int num) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		combo.selectByIndex(num);
	}

	public boolean retornaRadioCombo(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}

	public boolean retornaIndex(String id, int num) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		combo.selectByIndex(num);
		return combo.equals(combo);
	}

	// ***** Combo *****//
	public void campoCombo(String idSelecionado, String valor) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(idSelecionado)));
		combo.selectByVisibleText(valor);
	}

	public void campoComboDeselecionado(String id, String valor) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		combo.selectByVisibleText(valor);
	}

	public String retornaFirstSelect(String id) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> retornaCombo(String id) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		List<WebElement> lista = combo.getAllSelectedOptions();
		List<String> valor = new ArrayList<String>();

		for (WebElement opcao : lista) {
			valor.add(opcao.getText());
		}
		return valor;
	}

	public int retornaComboVarios(String id) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		List<WebElement> lista = combo.getOptions();
		return lista.size();
	}

	public boolean retornaOpcaoCombo(String id, String valor) {
		Select combo = new Select(DriverFactory.getDriver().findElement(By.id(id)));
		List<WebElement> opcoes = combo.getOptions();

		for (WebElement opcao : opcoes) {
			if (opcao.getText().equals(valor)) {
				return true;
			}
		}
		return false;
	}

	// ***** Botao e Link *****//
	public void clicarBotao(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}

	public void clicarLink(String id) {
		DriverFactory.getDriver().findElement(By.linkText(id)).click();
	}
	
	// ***** Obter texto *****//
	public String obtemTexto(String id) {
		return obtemTexto(By.id(id));
	}

	public String obtemTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}

	// ***** Alertas *****//
	public String msgAlerta() {
		return DriverFactory.getDriver().switchTo().alert().getText();
	}

	public String alertaAceita() {
		Alert alerta = DriverFactory.getDriver().switchTo().alert();
		String texto = alerta.getText();
		alerta.accept();
		return texto;
	}

	public String alertaNegado() {
		Alert alerta = DriverFactory.getDriver().switchTo().alert();
		String texto = alerta.getText();
		alerta.dismiss();
		return texto;
	}

	public String alertaEscreve(String valor) {
		Alert alerta = DriverFactory.getDriver().switchTo().alert();
		alerta.sendKeys(valor);
		alerta.accept();
		return valor;
	}

	// ***** Frames e Janelas *****//
	public void entrarFramer(String id) {
		DriverFactory.getDriver().switchTo().frame(id);
	}

	public void sairFramer() {
		DriverFactory.getDriver().switchTo().defaultContent();
	}

	public void trocarJanelaFramer(String id) {
		DriverFactory.getDriver().switchTo().window(id);
	}

	// ***** JS *****//
	public Object executarJS(String cmd, Object... parametro) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		return js.executeScript(cmd, parametro);
	}

	// ***** Tabelas *****//
//	public void clicarBotaoTabela(String nomeColuna, Object valor, String nomeColunaClicar) {
//		//*[@id='elementosForm:tableUsuarios']/tbody/tr[2]/td[3]
//		// procurar coluna
//		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
//		
//		int idColuna = obterIndiceColuna(nomeColuna, tabela);		
//		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
//		int idBotao = obterIndiceColuna(nomeColunaClicar, tabela);
//		
//		WebElement botao = tabela.findElement(By.xpath("/tbody/tr["+idLinha+"]/td["+idBotao+"]"));
//		botao.click();
//		
//	}
//
//	protected int obterIndiceLinha(Object valor, WebElement tabela, int idColuna) {
//		List<WebElement> linha = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
//		int idLinha = 0;
//		for (int l = 0; l < linha.size(); l++) {
//			if (linha.get(l).getText().equals(valor)) {
//				idLinha = l + 1;
//				break;
//			}
//		}
//		return idLinha;
//	}
//	
//	protected int obterIndiceColuna(String nomeColuna, WebElement tabela) {
//		List<WebElement> coluna = tabela.findElements(By.xpath("./thead/th["+nomeColuna+"]"));
//		int idColuna = 0;
//		for (int c = 0; c < coluna.size(); c++) {
//			if (coluna.get(c).getText().equals(nomeColuna)) {
//				idColuna = c + 1;
//				break;
//			}
//		}
//		return idColuna;
//	}
		
		
		/*
		int idColuna = extrairIndiceColuna(colunaBusca, tabela);

		// procurar linha
		int idLinha = extrairIndiceLinha(valor, tabela, idColuna);
		

		// procurar botao
		int idColunaBotao = extrairIndiceColuna(colunaBotao, tabela);
		
		// clicar no botao da linha x coluna
		WebElement botao = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		botao.findElement(By.xpath(".//imput")).click();;
	}

	protected int extrairIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linha = tabela.findElements(By.xpath("./tbody/tr/td[\"+idColuna+\"]"));
		int idLinha = -1;
		for (int i = 0; i < linha.size(); i++) {
			if (linha.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int extrairIndiceColuna(String colunaBusca, WebElement tabela) {
		List<WebElement> coluna = tabela.findElements(By.xpath(".//th"));

		int idColuna = -1;
		for (int i = 0; i < coluna.size(); i++) {
			if (coluna.get(i).getText().equals(colunaBusca)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
	*/
	
}



	
