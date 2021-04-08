package pages;

import org.openqa.selenium.By;

import util.BasePage;

public class CampoTreinamentoPage extends BasePage {
	
	public void setNome(String nome) {
		util.campoTexto("elementosForm:nome", nome);
	}
		
	public void setSobrenome(String sobrenome) {
		util.campoTexto("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		util.campoRadioCombo("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		util.campoRadioCombo("elementosForm:sexo:1");
	}
	
	public void setComidaCarne() {
		util.campoRadioCombo("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		util.campoRadioCombo("elementosForm:comidaFavorita:1");
	}
	
	public void setComidaPizza() {
		util.campoRadioCombo("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		util.campoRadioCombo("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		util.campoCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsporte(String... esporte) {
		for (String lista: esporte)
			util.campoCombo("elementosForm:esportes", lista);
	}
	
	public void setSugestao(String sugestao) {
		util.campoTexto("elementosForm:sugestoes", sugestao);
	}
	
	//***** Resultado Cadastro *****//
	public String obterResultadoCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterSobrenomeCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descSobrenome']/span"));
		
	}
	
	public String obterSexoCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		return util.obtemTexto(By.xpath("//*[@id='descEsportes']/span"));
	}
	
	//***** Botao e Link *****//
	public void botaoCadastrarPage() {
		util.clicarBotao("elementosForm:cadastrar");
	}
	
	public void botaoCliqueAquiPage() {
		util.clicarBotao("buttonSimple");
	}
	
	public void linkVoltarPage() {
		util.clicarLink("Voltar");
	}
	
	public void botaoAlertPage() {
		util.clicarBotao("alert");
	}
	
	public void botaoConfirmPage() {
		util.clicarBotao("confirm");
	}
	
	public void botaoPromptPage() {
		util.clicarBotao("prompt");
	}
	
	public void botaoDentroFramePage() {
		util.clicarBotao("frameButton");
	}
	
	public void botaoAbrirPopupPage() {
		util.clicarBotao("buttonPopUpEasy");
	}
}
