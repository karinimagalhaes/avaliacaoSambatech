package br.com.sambatech.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public DataDriven() throws Exception {}
	
	static String path = System.getProperty("user.dir");
	private static String separator = System.getProperty("file.separator");
	private static final File dataDrivenFile = new File(path + separator + "src" + separator + "test" + separator + "resources" + separator + "MassaDeDados.xlsx");

	FileInputStream dataDriven = new FileInputStream(dataDrivenFile);
	XSSFWorkbook dados = new XSSFWorkbook(dataDriven);

	/*
	 *  Ler as informações de acesso ao sistema
	 */

	public String getLink() {
		return dados.getSheet("Massa").getRow(0).getCell(1).getStringCellValue();
	}

}
