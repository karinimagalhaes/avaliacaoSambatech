package br.com.sambatech.SuiteDashboard;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.Paginas.PaginaBase;
import br.com.sambatech.Paginas.PaginaDashboard;
import br.com.sambatech.Paginas.PaginaLogin;
import br.com.sambatech.Util.DataDriven;

/**
 * Classe de teste com os fluxos do cadastro de projeto
 * @author MagalhaK
 *
 */
public class CadastroProjetoTest {

	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private PaginaDashboard paginaDashboard;
	private DataDriven dataDriven;
	
	public CadastroProjetoTest() throws IOException {
		this.paginaBase = new PaginaBase();
		this.driver = paginaBase.getDriver();
		this.paginaLogin = new PaginaLogin(driver);	
		this.dataDriven = new DataDriven();
	}
	
	@Before
	public void setUp() {
		paginaBase.acessoUrl();
	}
	
	
	/**
	 * Teste referente a Issue #8 cadastrada no gitHub
	 */
	
	@Test
	public void cadastrarNovoProjetoTest() {
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject(dataDriven.getNomeProjetoNotificacao(), dataDriven.getDescricaoNotificacao());
		paginaDashboard.alterarProjeto(dataDriven.getNomeProjetoNotificacao());
		
		// Validação da quatidade de notificações exibidas no balão após cadastrar um projeto
		Assert.assertEquals("0", paginaDashboard.getNumNotificacoes());
	}
	
	
	/**
	 * Teste do cadastro de um projeto que já está na aplicação
	 */
	@Test
	public void cadastrarProjetoDuplicadoTest() {
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject(dataDriven.getNomeProjetoDuplicado(), dataDriven.getNomeProjetoDuplicado());
		
		// Validação da mensagem de erro exibida para o usuário
		String messageError = paginaDashboard.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		Assert.assertEquals("Ops! Já existe esse nome de projeto na sua conta. Por favor insira outro", messageError);
	}
	
	
	/**
	 * Teste para validar o cadastro de projeto sem os campos preenchidos
	 */
	@Test
	public void campoObrigatorioNomeProjetoTest() {
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("", "");
		
		// validação da mensagem de erro de campo obrigatório
		String messageError = paginaDashboard.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		Assert.assertEquals("Por favor insira um nome para o projeto", messageError);
	}
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
	
}

