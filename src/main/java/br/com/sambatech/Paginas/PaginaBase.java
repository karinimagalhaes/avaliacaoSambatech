package br.com.sambatech.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {
	private WebDriver driver;
	
	public static String separator = System.getProperty("file.separator");
	
	public PaginaBase(WebDriver driver){
		this.driver = driver;
	}
	
	public PaginaBase(){
		System.setProperty("webdriver.chrome.driver",  "drivers" + separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void acessoUrl(){
		getDriver().navigate().to("http://web1.qa.sambatech.com:10000");
	}
	
	public void closeDriver(){
		getDriver().quit();
	}
	
	public void waitElementsId(String id){
		WebDriverWait wait = new WebDriverWait(getDriver(), 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void waitElementsClass(String className){
		WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}
	
	public void waitElementsXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitElementsName(String name){
		WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
}
