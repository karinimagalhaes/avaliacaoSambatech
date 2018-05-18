package br.com.sambatech.SuiteUpload;

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
import br.com.sambatech.Paginas.PaginaUpload;
import br.com.sambatech.Util.DataDriven;

public class UploadTest {
	WebDriver driver;
	private PaginaBase paginaBase;
	private PaginaLogin paginaLogin;
	private PaginaUpload paginaUpload;
	private DataDriven dataDriven;
	
	private String path = System.getProperty("user.dir" + PaginaBase.separator + "arquivos" +  PaginaBase.separator + "DevOps.png");
	
	public UploadTest() throws IOException {
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
	 * Teste carregar imagem de tamanho válido
	 */
	@Test
	public void carregarImagemTest() {
		
		paginaLogin.realizarLogin(dataDriven.getLoginValido(), dataDriven.getSenhaValida());
		paginaUpload = new PaginaUpload(driver);
		paginaUpload.acessarMenuUpload();
		paginaUpload.realizarUpload(path);
		
		// Validação da mensagem de erro exibida para o usuário
		//String messageError = paginaUpload.getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[2]/form/div[1]/span")).getText();
		//Assert.assertEquals("Ops! Já existe esse nome de projeto na sua conta. Por favor insira outro", messageError);
	}
	
	
	
	@After
	public void closeDriver() {
		paginaBase.closeDriver();
	}
}

