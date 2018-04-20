package tum0r.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tum0r.error.FileTypeException;
import tum0r.misc.ToolsConfig;

public class Excel {

	private Sheet sheet;
	private Workbook workbook;

	private void getWorkbook(String path) throws FileTypeException{
		try {
			InputStream inputStream = new FileInputStream(path);
			if (path.toLowerCase().endsWith(ToolsConfig.XLS)) {
				workbook = new HSSFWorkbook(inputStream);
			} else if (path.toLowerCase().endsWith(ToolsConfig.XLSX)) {
				workbook = new XSSFWorkbook(inputStream);
			}else {
				throw new FileTypeException("the excel type is error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String[][] getResult() {
		if (sheet != null) {
			int rowCount = sheet.getLastRowNum() + 1;
			String[][] result = new String[rowCount][];
			for (int row = 0; row < rowCount; row++) {
				Row line = sheet.getRow(row);
				int cellCount = line.getLastCellNum() + 1;
				result[row] = new String[cellCount];
				for (int cell = 0; cell < cellCount; cell++) {
					Cell box = line.getCell(cell);
					if (box != null) {
						box.setCellType(CellType.STRING);
						result[row][cell] = box.getStringCellValue().replace("'", "\'").replace("\"", "\\\"");
					} else {
						result[row][cell] = "";
					}
				}
			}
			return result;
		}
		return null;
	}

	public String[][] read(String path, String sheetName) {
		try {
			getWorkbook(path);
			sheet = workbook.getSheet(sheetName);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileTypeException e) {
			e.printStackTrace();
		}
		return getResult();
	}

	public String[][] read(String path, int sheetIndex) {
		try {
			getWorkbook(path);
			sheet = workbook.getSheetAt(sheetIndex);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileTypeException e) {
			e.printStackTrace();
		}
		return getResult();
	}

	public boolean save(String path, String sheetName, String[][] data) {
		try {
			if (path.toLowerCase().endsWith(ToolsConfig.XLS)) {
				workbook = new HSSFWorkbook();
			} else if (path.toLowerCase().endsWith(ToolsConfig.XLSX)) {
				workbook = new XSSFWorkbook();
			}
			sheet = workbook.createSheet(sheetName);
			for (int rowCount = 0; rowCount < data.length; rowCount++) {
				Row row = sheet.createRow(rowCount);
				for (int cellCount = 0; cellCount < data[rowCount].length; cellCount++) {
					Cell cell = row.createCell(cellCount, CellType.STRING);
					cell.setCellValue(data[rowCount][cellCount]);
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
