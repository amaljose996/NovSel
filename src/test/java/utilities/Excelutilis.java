package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilis {
	
	public static String getCellValue(String xl, String sheet, int r, int c)

	{
		try
		{
			FileInputStream fi=new FileInputStream(xl);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFCell cell =wb.getSheet(sheet).getRow(r).getCell(c);
			
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
			//	double v=cell.getNumericCellValue();
			//	int va1=(int)v;
			//	return String.valueOf(va1);
				return cell.getRawValue();
			}
			
		}
		catch (Exception e)
		{
			return "";
		}
	}
	public static int rowCount(String xl,String sheet)
	{
		try
		{
			// file f=new file(xl);
			FileInputStream fi=new FileInputStream(xl);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			
			return wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e)
		{
			return 0;
		}
	}
}
