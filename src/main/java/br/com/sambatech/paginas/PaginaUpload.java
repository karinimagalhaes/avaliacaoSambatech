package br.com.sambatech.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.sambatech.util.DataDriven;

public class PaginaUpload extends PaginaBase {
	
	private String path = System.getProperty("user.dir" + DataDriven.separator + "arquivos" +  DataDriven.separator + "DevOps.png");

	public PaginaUpload(WebDriver driver) {
		super(driver);
	}
	
	public void acessarMenuUpload() {
		waitElementsId("mn-upload");
		getDriver().findElement(By.id("mn-upload")).click();
	}
	
	public void realizarUpload() {
		waitElementsXpath("//*[@id='upload-process']/div[2]/div[2]/input");
		getDriver().findElement(By.xpath("//*[@id='upload-process']/div[2]/div[2]/input")).sendKeys(path);
	}
	
	
}
