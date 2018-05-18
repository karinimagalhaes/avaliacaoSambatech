package br.com.sambatech.SuiteLogin;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.Paginas.PaginaBase;
import br.com.sambatech.Paginas.PaginaRecuperarSenha;
import br.com.sambatech.Util.DataDriven;

public class RecuperarSenhaTest {
	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaRecuperarSenha paginaRecuperarSenha;
	private DataDriven dataDriven;
	
	public RecuperarSenhaTest() throws IOException {
		this.paginaBase = new PaginaBase();			
		this.driver = paginaBase.getDriver();		
		this.paginaRecuperarSenha = new PaginaRecuperarSenha(driver);	
		this.dataDriven = new DataDriven();
	}
	
	@Before
	public void setUp() {
		paginaBase.acessoUrl();
	}
	
	
	/**
	 * Teste recuperar senha de conta cadastrada
	 */
	@Test
	public void contaValidaTest() {
		paginaRecuperarSenha.linkRecuperarSenha();
		paginaRecuperarSenha.recuperarSenha(dataDriven.getLoginValido());
		
		// Validação do usuário exibido ao acessar a aplicação
		paginaBase.waitElementsXpath("//*[@id='main-wrapper']/div/div[2]/div[2]/strong");
		Assert.assertEquals(" We sent you an email with all instructions to obtain your new password.\r\n" + 
				"			", paginaBase.getDriver().findElement(By.xpath("//*[@id='main-wrapper']/div/div[2]/div[2]/strong")).getText() + paginaBase.getDriver().findElement(By.xpath("//*[@id='main-wrapper']/div/div[2]/div[2]")).getText());
	}
	
	/**
	 * Teste recuperação de senha informando e-mail com formato inválido
	 */
	@Test
	public void emailFormatoInvalidoTest() {
		paginaRecuperarSenha.linkRecuperarSenha();
		paginaRecuperarSenha.recuperarSenha(dataDriven.getEmailInvalido());
		
		// Validação do usuário exibido ao acessar a aplicação
		paginaBase.waitElementsXpath("//*[@id='main-wrapper']/div/div[2]/div[3]/span");
		Assert.assertEquals("Please insert a valid email", paginaBase.getDriver().findElement(By.xpath("//*[@id='main-wrapper']/div/div[2]/div[3]/span")).toString());
		
	}
	
	/**
	 * Teste recuperação de senha de conta inexistente
	 */
	@Test
	public void contaInexistenteTest() {
		paginaRecuperarSenha.linkRecuperarSenha();
		paginaRecuperarSenha.recuperarSenha(dataDriven.getContaInexistente());
		
		// Validação do usuário exibido ao acessar a aplicação
		paginaBase.waitElementsXpath("//*[@id='main-wrapper']/div/div[2]/div[3]/span");
		Assert.assertEquals("Ops! The email was not found in our system. Please try again.",paginaBase.getDriver().findElement(By.xpath("//*[@id='main-wrapper']/div/div[2]/div[3]/span")).toString());
		
	}
	
	
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
}
