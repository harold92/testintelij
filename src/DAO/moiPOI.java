package DAO;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class moiPOI {

    public static void main(String[] args) throws IOException {

//        FileInputStream in = new FileInputStream(new File("prof.xlsx"));
//        XSSFWorkbook workbook = new XSSFWorkbook(in);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = sheet.iterator();
//        while(sheet.iterator().hasNext())
//        {
//            Row row = sheet.iterator().next();
//            Iterator<Cell> iterator = row.cellIterator();
//            while(iterator.hasNext()){
//                Cell cell = iterator.next();
//                if (row.getRowNum()>0){
//                    if (cell.getColumnIndex()==1)
//                        System.out.println(cell.getStringCellValue());
//                }
//            }
//        }
    }
}
