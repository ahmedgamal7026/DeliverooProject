package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null ; 
	
	public FileInputStream getFileInputStream() throws FileNotFoundException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/Data/data.xlsx"; 
		File srcFile = new File(filePath);
		
//		try {
			fis = new FileInputStream(srcFile);
//		} catch (FileNotFoundException e) {
//			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
//			System.exit(0);
//		}
		return fis ; 
	}
	
	public Object[][] getExcelData(int sheetnum) throws IOException
	{
		fis = getFileInputStream(); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetnum); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 1 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}
}
