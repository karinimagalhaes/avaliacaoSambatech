package br.com.sambatech.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaRecuperarSenha extends PaginaBase {
	
	public PaginaRecuperarSenha(WebDriver driver) {
		super(driver);
	}
	
	public void linkRecuperarSenha() {
		waitElementsId("forgot-pwd-link");
		getDriver().findElement(By.id("forgot-pwd-link")).click();
	}
	
	public void recuperarSenha(String email) {
		waitElementsName("email");
		getDriver().findElement(By.name("email")).sendKeys(email);
		getDriver().findElement(By.xpath("//*[@id='type-email']/div[2]/div[1]/button")).click();
	}
}
