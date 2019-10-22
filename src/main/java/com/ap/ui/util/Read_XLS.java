package com.ap.ui.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_XLS {

	public String fileName;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet ws = null;

	List<String> list = new ArrayList<String>();

	public Read_XLS(String fileName, String relativePath) {
		this.fileName = fileName;
		try {
			ipstr = new FileInputStream(relativePath+fileName);
			wb = new XSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public int retrieveNoOfRows(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex==-1) {
			return 0; }
		else {
			ws = wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum()+1;
			return rowCount;
		}

	}

	public int retrieveNoOfCol(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex==-1) {
			return 0; }
		else {
			ws = wb.getSheetAt(sheetIndex);
			int colCount = ws.getRow(0).getLastCellNum() + 1;
			return colCount;
		}

	}

	public String retrieveToRunFlag(String wsName, String colName, String rowName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex==-1) {
			return null;
		}
		else {
			int rowNum = retrieveNoOfCol(wsName);
			int colNum = retrieveNoOfCol(wsName);
			int colNumber = -1;
			int rowNumber = -1;

			XSSFRow suiteRow = ws.getRow(0);
			for (int i = 0; i < colNum; i++) {
				if (suiteRow.getCell(i).getStringCellValue().equals(colName.trim())) {
					colNumber = i;
				}
			}
			if (colNumber==-1) {
				return "";

			}

			for (int j = 0; j < rowNum; j++) {
				XSSFRow suiteCol = ws.getRow(j);
				if (suiteCol.getCell(0).getStringCellValue().equals(rowName.trim())) {
					rowNumber = j;
				}

			}
			if (rowNumber==-1) {
				return "";
			}
			XSSFRow row = ws.getRow(rowNumber);
			XSSFCell cell = row.getCell(colNumber);
			if(cell == null) {
				return "";
			}
			String value = cellToString(cell);
			return value;
		}
	}

	public List<String> retrieveTestData(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex==-1) {
			return null;
		}
		else {
			int rowNumber = retrieveNoOfRows(wsName);
			int colNumber = retrieveNoOfCol(wsName);

			for(int i=0; i<rowNumber;i++) {
				XSSFRow row = ws.getRow(i);
				for(int j=0; j<colNumber; j++) {
					if(row == null) {
						list = null;
					}else {
						XSSFCell cell = row.getCell(j);
						if (cell == null) {
							list = null;
						}else {
							cell.setCellType(CellType.STRING);
							String value = cellToString(cell);
							System.out.println(value);
							list.add(value);
						}
					}
				}

			}
		}
		return list;

	}


	public Object[][] retrieveTestData1(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex==-1) {
			return null;
		}
		else {
			int rowNumber = retrieveNoOfRows(wsName);
			int colNumber = retrieveNoOfCol(wsName);

			Object [][] data = new Object[rowNumber-1][colNumber];

			for(int i=0; i<rowNumber-1;i++) {
				XSSFRow row = ws.getRow(i+1);
				for(int j=0; j<colNumber; j++) {
					if(row == null) {
						data[i][j] = "";
					}else {
						XSSFCell cell = row.getCell(j);
						if (cell == null) {
							data[i][j] = "";
						}else {
							cell.setCellType(CellType.STRING);
							String value = cellToString(cell);
							data[i][j]=value;
						}
					}
				}
			}
			return data;
		}

	}

	@SuppressWarnings("deprecation")
	public static String cellToString(XSSFCell cell) {

		int type;
		Object result;
		type = cell.getCellType();
		switch (type) {
		case 0:
			result = cell.getNumericCellValue();
			break;

		case 1:
			result = cell.getNumericCellValue();
			break;

		default:
			throw new RuntimeException("Unsupported cell");
		}
		return result.toString();

	}






}
