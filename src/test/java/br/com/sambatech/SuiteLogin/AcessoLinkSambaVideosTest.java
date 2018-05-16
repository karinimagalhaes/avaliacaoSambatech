package br.com.sambatech.SuiteLogin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.paginas.PaginaBase;
import br.com.sambatech.paginas.PaginaLogin;
import br.com.sambatech.util.DataDriven;


public class AcessoLinkSambaVideosTest {
	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private DataDriven dataDriven;
	
	public AcessoLinkSambaVideosTest() {
		this.paginaBase = new PaginaBase();			
		this.driver = paginaBase.getDriver();		
		this.paginaLogin = new PaginaLogin(driver);	
	}
	
	@Before
	public void setUp() {
		paginaBase.acessoUrl();
	}
	
	@Test
	public void acessarLinkSambaVideosTest() {
		paginaLogin.linkKnowSambaVideos();
		
		
	}
}
