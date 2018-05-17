package br.com.sambatech.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PaginaDashboard extends PaginaBase {
	
	public PaginaDashboard(WebDriver driver) {
		super(driver);
	}
	
	public void abrirNavbarProject() {
		waitElementsId("navbar-project-name");
		getDriver().findElement(By.id("navbar-project-name")).click();
	}
	
	public void createProject(String nameProject, String descricao) {
		abrirNavbarProject();
		getDriver().findElement(By.id("new_project")).click();
		getDriver().findElement(By.name("name")).sendKeys(nameProject);
		getDriver().findElement(By.name("description")).sendKeys(descricao);
		getDriver().findElement(By.xpath("//*[@id='modalContainer']/div/div[3]/button")).click();
	}
	
	public void alterarProjeto(String nomeProjeto) {
		abrirNavbarProject();
		getDriver().findElement(By.id("change_project")).click();
		getDriver().findElement(By.id("project-search")).sendKeys(nomeProjeto);
		getDriver().findElement(By.id("project-search")).sendKeys(Keys.TAB);
		getDriver().findElement(By.id("project-search")).sendKeys(Keys.ENTER);		
	}
	
	public String getNumNotificacoes() {
		return getDriver().findElement(By.xpath("//*[@id='wrap']/div/div[2]/form/ul[1]/li[2]/label/label")).getText();
	}
	
	public String getNotificacao() {
		return getDriver().findElement(By.className("sv-notification-list")).getText();
	}
}
