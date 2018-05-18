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
	
	/**
	 * Lê os dados da aba Login
	 * @return
	 */
	
	public String getLoginValido() {
		return dados.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
	}
	
	public String getSenhaValida() {
		return dados.getSheet("Login").getRow(1).getCell(1).getStringCellValue();
	}
	
	public String getContaInexistente() {
		return dados.getSheet("Login").getRow(2).getCell(1).getStringCellValue();
	}
	
	public String getEmailInvalido() {
		return dados.getSheet("Login").getRow(3).getCell(1).getStringCellValue();
	}
	
	public String getSenhaInvalida() {
		return dados.getSheet("Login").getRow(4).getCell(1).getStringCellValue();
	}
	
	/**
	 * Lê os dados da aba Projeto
	 * @return
	 */
	public String getNomeProjetoNotificacao() {
		return dados.getSheet("Projeto").getRow(0).getCell(1).getStringCellValue();
	}
	
	public String getDescricaoNotificacao() {
		return dados.getSheet("Projeto").getRow(1).getCell(1).getStringCellValue();
	}
	
	public String getNomeProjetoDuplicado() {
		return dados.getSheet("Projeto").getRow(2).getCell(1).getStringCellValue();
	}
	
	public String getDescricaoDuplicado() {
		return dados.getSheet("Projeto").getRow(3).getCell(1).getStringCellValue();
	}
}
