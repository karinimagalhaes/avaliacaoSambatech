package br.com.sambatech.SuiteLogin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.paginas.PaginaBase;
import br.com.sambatech.paginas.PaginaLogin;
import br.com.sambatech.util.DataDriven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class LoginValidoTest {

	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private DataDriven dataDriven;
	
	public LoginValidoTest() {
		this.paginaBase = new PaginaBase();			
		this.driver = paginaBase.getDriver();		
		this.paginaLogin = new PaginaLogin(driver);	
	}
	
	@Before
	public void setUp() {
		paginaBase.acessoUrl();
	}
	
	@Test
	public void acessoValidoTest() {
		try {
			paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
			paginaBase.waitElementsClass("dropdown-toggle");
			Assert.assertEquals(paginaBase.getDriver().findElement(By.xpath("//*[@class='dropdown-toggle']/span")).getText(), "Avaliação QA");
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			Assert.fail();
		}
		
	}
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
}
