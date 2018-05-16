package br.com.sambatech.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends PaginaBase{
	
	public PaginaLogin(WebDriver driver) {
		super(driver);
	}
	
	public void realizarLogin(String email, String password) {
		waitElementsId("inputEmail");
		getDriver().findElement(By.id("inputEmail")).sendKeys(email);
		getDriver().findElement(By.id("inputPassword")).sendKeys(password);
		getDriver().findElement(By.id("login")).click();
	}
	
	public void linkRecuperarSenha() {
		getDriver().findElement(By.id("forgot-pwd-link")).click();
	}
	
	public void recuperarSenha(String email) {
		getDriver().findElement(By.id("email")).sendKeys(email);
		getDriver().findElement(By.xpath("//*[@id='type-email']/div[2]/div[1]/button")).click();
	}
	
	public void linkKnowSambaVideos() {
		getDriver().findElement(By.id("know-samba")).click();
	}
	
	public void linkSuporte() {
		getDriver().findElement(By.id("support-central")).click();
	}

}
