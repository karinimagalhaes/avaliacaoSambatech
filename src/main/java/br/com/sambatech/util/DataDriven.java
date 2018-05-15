package br.com.sambatech.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public DataDriven() throws Exception {}
	
	static String path = System.getProperty("user.dir");
	public static String separator = System.getProperty("file.separator");
	private static final File dataDrivenFile = new File(path + separator + "src" + separator + "test" + separator + "resources" + separator + "dataDriven.xlsx");

	FileInputStream dataDriven = new FileInputStream(dataDrivenFile);
	XSSFWorkbook dados = new XSSFWorkbook(dataDriven);

	/*
	 *  Ler as informações de acesso ao sistema
	 */

	public String getLink() {
		return dados.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
	}
	
	public String getEmailValido() {
		return dados.getSheet("Login").getRow(1).getCell(1).getStringCellValue();
	}
	
	public String getSenhaValida() {
		return dados.getSheet("Login").getRow(2).getCell(1).getStringCellValue();
	}
	
	public String getEmailInvalido() {
		return dados.getSheet("Login").getRow(3).getCell(1).getStringCellValue();
	}
	
	public String getEmailContaInexistente() {
		return dados.getSheet("Login").getRow(4).getCell(1).getStringCellValue();
	}

}
