package br.com.sambatech.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends PaginaBase{
	
	public PaginaLogin(WebDriver driver) {
		super(driver);
	}
	
	public void realizarLogin(String email, String password) {
		waitElementsId("inputEmail");						// Aguarda o carregamento da tela
		getDriver().findElement(By.id("inputEmail")).sendKeys(email);
		getDriver().findElement(By.id("inputPassword")).sendKeys(password);
		getDriver().findElement(By.id("login")).click();
	}

}
