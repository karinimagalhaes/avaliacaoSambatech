package br.com.sambatech.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PaginaUpload extends PaginaBase{
	
	public PaginaUpload(WebDriver driver) {
		super(driver);
	}
	
	public void acessarMenuUpload() {
		waitElementsId("mn-upload");
		getDriver().findElement(By.id("mn-upload")).click();
	}
	
	public void realizarUpload(String path) {
		waitElementsXpath("//*[@id='upload-process']/div[2]/div[2]/input");
		getDriver().findElement(By.xpath("//*[@id='upload-process']/div[2]/div[2]/input")).sendKeys(path);
		getDriver().findElement(By.xpath("//*[@id='upload-process']/div[2]/div[2]/input")).sendKeys(Keys.ENTER);
	}
}
