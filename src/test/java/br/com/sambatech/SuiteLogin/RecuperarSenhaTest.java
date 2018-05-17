package br.com.sambatech.SuiteLogin;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		paginaRecuperarSenha.recuperarSenha("");
		
		// Validação do usuário exibido ao acessar a aplicação
		Assert.assertEquals("","");
	}
	
	/**
	 * Teste recuperação de senha informando e-mail com formati inválido
	 */
	@Test
	public void emailFormatoInvalidoTest() {
		paginaRecuperarSenha.linkRecuperarSenha();
		paginaRecuperarSenha.recuperarSenha("");
		
		// Validação do usuário exibido ao acessar a aplicação
		Assert.assertEquals("","");
		
	}
	
	/**
	 * Teste recuperação de senha de conta inexistente
	 */
	@Test
	public void contaInexistenteTest() {
		paginaRecuperarSenha.linkRecuperarSenha();
		paginaRecuperarSenha.recuperarSenha("");
		
		// Validação do usuário exibido ao acessar a aplicação
		Assert.assertEquals("","");
		
	}
	
	
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
}
