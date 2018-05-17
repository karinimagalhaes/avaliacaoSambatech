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
	
	@Test
	public void cadastrarNovoProjetoTest() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("Teste Notificação", "Teste da notificação após cadastrar projeto");
		paginaDashboard.alterarProjeto("Teste Notificação");
		Assert.assertEquals("0", paginaDashboard.getNumNotificacoes());
		//Assert.assertEquals("Automação Project", projectName);
	}
	
	@Test
	public void cadastrarProjetoDuplicadoTest() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("QA Samba", "Projeto cadastrado pelo teste automatizado");
		String messageError = paginaDashboard.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		Assert.assertEquals("Ops! Já existe esse nome de projeto na sua conta. Por favor insira outro", messageError);
	}
	
	@Test
	public void campoObrigatorioNomeProjetoTest() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaDashboard = new PaginaDashboard(driver);
		paginaDashboard.createProject("", "");
		String messageError = paginaDashboard.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		Assert.assertEquals("Por favor insira um nome para o projeto", messageError);
	}
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
	
}

