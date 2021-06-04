package activities;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity15 {

	private static String FileName = "TestSheet.xlsx";  
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DataTypes in JAVA");
		
		Object[][] dataTypes = {
				{"DataType","Type","Size (in Bytes)"},
				{"int","Primitive","2"},
				{"float","Primitive","4"},
				{"double","Primitive","8"},
				{"char","Primitive","1"},
				{"String","non-Primitive","Not Fixed"}
		};
		
		System.out.println("Creating excel file");
		
		int rowNum = 0;
		for(Object[] datatype : dataTypes) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for(Object field : datatype) {
				Cell cell = row.createCell(colNum++);
				if(field instanceof String)
				cell.setCellValue((String) field);
				else if(field instanceof Integer)
					cell.setCellValue((Integer) field);
			}
		}
		
		FileOutputStream outputStream = new FileOutputStream(FileName);
		workbook.write(outputStream);
		workbook.close();
		System.out.println("Done");
	}

}
