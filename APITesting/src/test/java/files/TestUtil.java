package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.*;

public class TestUtil  {
	
	static String FilePath = "C:\\Users\\Admin\\eclipse-workspace\\APITesting\\src\\main\\java\\Resources\\TestData.xlsx";
	private static XSSFSheet sheet =null;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFRow row = null;
	public static XSSFCell cell =null;
	
	public static ArrayList<Object[]> getTestData() throws Exception {
		
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		FileInputStream fis = new FileInputStream(FilePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("AddPlace");
		int rowCount = sheet.getLastRowNum()+1;
		int colCount = sheet.getRow(0).getLastCellNum();
		for(int i=2;i<=rowCount;i++) {
			String TestNo = getCellData(i, "TestNo");
			String Latitude = getCellData(i, "Latitude");
			String Longitutde = getCellData(i, "Longitutde");
			String Accuracy = getCellData(i, "Accuracy");
			String Name = getCellData(i, "Name");
			String Phone = getCellData(i, "Phone");
			String Address = getCellData(i, "Address");
			String Website = getCellData(i, "Website");
			String Lanuguage = getCellData(i, "Lanuguage");
			Object ob[] = { Latitude, Longitutde, Accuracy, Name, Phone, Address,Website,Lanuguage};
			data.add(ob);
//			System.out.println(TestNo + Latitude + Longitutde+Accuracy+Name+Phone+Website+Lanuguage);
//			System.out.println(Latitude);
		}
		
		
		
		return data ;
	}
	public static String getCellData1(int RowNum,String Column) throws Exception {
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream(FilePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("AddPlace");
		int rowCount = sheet.getLastRowNum();
		XSSFRow row0 = sheet.getRow(0);
		int colCount =0;
		for(int i=0;i<row0.getLastCellNum();i++) {
			if(row0.getCell(i).equals(Column)) {
				colCount =i;
			}
		}
		
		XSSFCell cell = sheet.getRow(RowNum-1).getCell(colCount);
		String Value = formatter.formatCellValue(cell);
		System.out.println("value is :"+Value);
		System.out.println("cell values is : "+cell.getCellType());
		
		return Value;
	}
	
	public static String getCellData( int RowNum,String ColumnName) throws IOException {

		if(RowNum<=0)
			return "";
		int colCount =-1;
		fis = new FileInputStream(FilePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("AddPlace");
		row = sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(ColumnName)) {
				colCount =i;}
			}
		row=sheet.getRow(RowNum-1);
		if(row==null)
			return "";
		
		cell=row.getCell(colCount);
		if(cell==null)
			return"";
		
//		System.out.println("if statement : "+cell.getCellType().equals(CellType.STRING));
//		System.out.println(cell.getCellType());

		if(cell.getCellType().equals(CellType.STRING)){
			return cell.getStringCellValue();
		}else if(cell.getCellType().equals(CellType.NUMERIC)) {
			return String.valueOf(cell.getNumericCellValue());
		}else if(cell.getCellType()==CellType.BLANK) {
			return "";
		}	else {
			return String.valueOf(cell.getBooleanCellValue());
		}
		
		
		
	}
	
	
	
	
	
}
