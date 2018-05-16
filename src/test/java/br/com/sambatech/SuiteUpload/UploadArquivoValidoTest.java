package br.com.sambatech.SuiteUpload;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.paginas.PaginaBase;
import br.com.sambatech.paginas.PaginaLogin;
import br.com.sambatech.paginas.PaginaUpload;
import br.com.sambatech.util.DataDriven;

public class UploadArquivoValidoTest {
	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private PaginaUpload paginaUpload;
	private DataDriven dataDriven;
	
	public UploadArquivoValidoTest() {
		this.paginaBase = new PaginaBase();			
		this.driver = paginaBase.getDriver();		
		this.paginaLogin = new PaginaLogin(driver);	
	}
	
	@Before
	public void setUp() {
		paginaBase.acessoUrl();
	}
	
	@Test
	public void uploadArquivoValido() {
		paginaLogin.realizarLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		paginaUpload = new PaginaUpload(paginaLogin.getDriver());
		paginaUpload.acessarMenuUpload();
		paginaUpload.realizarUpload();
		
		
		
	}
}
