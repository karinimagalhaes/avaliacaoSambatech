package br.com.sambatech.SuiteLogin;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.Paginas.PaginaBase;
import br.com.sambatech.Paginas.PaginaLogin;
import br.com.sambatech.Util.DataDriven;

/**
 * Classe de teste com os fluxos de acesso do usuário a aplicação
 * @author MagalhaK
 *
 */
public class LoginTest {
	
	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private DataDriven dataDriven;
	
	public LoginTest() throws IOException {
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
	 * Teste de login com as credenciais válidas
	 */
	@Test
	public void loginValidoTest() {
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaBase.waitElementsClass("dropdown-toggle");
		
		// Validação do usuário exibido ao acessar a aplicação
		Assert.assertEquals(paginaBase.getDriver().findElement(By.xpath("//*[@class='dropdown-toggle']/span")).getText(), "Avaliação QA");
	}
	
	/**
	 * Teste de login com as credenciais inválidas
	 */
	@Test
	public void loginInvalidoTest() {
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaBase.waitElementsClass("dropdown-toggle");
		
		// Validação do usuário exibido ao acessar a aplicação
		Assert.assertEquals(paginaBase.getDriver().findElement(By.xpath("//*[@class='dropdown-toggle']/span")).getText(), "Avaliação QA");
	}
	
	
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}

}
