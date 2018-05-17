package br.com.sambatech.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.sambatech.Paginas.PaginaBase;

public class DataDriven {
	
	public DataDriven() throws IOException {
	}

	private static String path = System.getProperty("user.dir") + PaginaBase.separator + "arquivos" + PaginaBase.separator + "DataDriven.xlsx";
	private static final File dataDrivenFile = new File(path);
	FileInputStream dataDriven = new FileInputStream(dataDrivenFile);
	XSSFWorkbook dados = new XSSFWorkbook(dataDriven);
	
	
	
	public String getLoginValido() {
		return dados.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
	}
	
	public String getSenhaValida() {
		return dados.getSheet("Login").getRow(1).getCell(1).getStringCellValue();
	}
}
