package br.com.sambatech.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaUpload extends PaginaBase {

	public PaginaUpload(WebDriver driver) {
		super(driver);
	}
	
	public void realizarUpload(String pathFile) {
		getDriver().findElement(By.xpath("//*[@id='upload-process']/div[2]/div[2]/input")).click();
	}
}
