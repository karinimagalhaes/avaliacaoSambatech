package br.com.sambatech.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.sambatech.util.DataDriven;

public class PaginaBase {
	WebDriver driver;
	
	public PaginaBase(WebDriver driver){
		this.driver = driver;
	}
	
	public PaginaBase(){
		System.setProperty("webdriver.chrome.driver", 
				"user.dir" + DataDriven.separator + "drivers" + DataDriven.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void acessoUrl(String url){
		getDriver().navigate().to(url);
	}
	
	public void closeDriver(){
		getDriver().quit();
	}
	
	public void waitElementsId(String id){
		WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
}
