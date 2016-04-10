package DAO;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class apach_poi {

    public static void main(String[] ss) throws IOException {
        FileInputStream fis = new FileInputStream(new File("prof03.xls"));
        Workbook wb = new HSSFWorkbook(fis); //or new XSSFWorkbook("/somepath/test.xls")
        Sheet sheet = wb.getSheetAt(0);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        // suppose your formula is in B3
        CellReference cellReference = new CellReference("b0");
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        //Cell cea =sheet.


        for(int i=1;i<sheet.getLastRowNum();i++) {

            System.out.println(cell.getStringCellValue());
            /*
            switch (evaluator.evaluateFormulaCell(cell)) {
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.println(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_ERROR:
                    System.out.println(cell.getErrorCellValue());
                    break;

                // CELL_TYPE_FORMULA will never occur
                case Cell.CELL_TYPE_FORMULA:
                    break;
            }
*/
}
    }

   /* public apach_poi() throws IOException {
        fis = new FileInputStream("/somepath/test.xls");
    }*/
}
