package br.com.sambatech.SuiteDashboard;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.Paginas.PaginaBase;
import br.com.sambatech.Paginas.PaginaDashboard;
import br.com.sambatech.Paginas.PaginaLogin;

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
	
	public CadastroProjetoTest() {
		this.paginaBase = new PaginaBase();
		this.driver = paginaBase.getDriver();
		this.paginaLogin = new PaginaLogin(driver);		
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
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("Teste Notificação", "Teste da notificação após cadastrar projeto");
		paginaDashboard.alterarProjeto("Teste Notificação");
		
		// Validação da quatidade de notificações exibidas no balão após cadastrar um projeto
		Assert.assertEquals("0", paginaDashboard.getNumNotificacoes());
	}
	
	
	/**
	 * Teste do cadastro de um projeto que já está na aplicação
	 */
	@Test
	public void cadastrarProjetoDuplicadoTest() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("QA Samba", "Projeto cadastrado pelo teste automatizado");
		
		// Validação da mensagem de erro exibida para o usuário
		String messageError = paginaDashboard.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		Assert.assertEquals("Ops! Já existe esse nome de projeto na sua conta. Por favor insira outro", messageError);
	}
	
	
	/**
	 * Teste para validar o cadastro de projeto sem os campos preenchidos
	 */
	@Test
	public void campoObrigatorioNomeProjetoTest() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
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

