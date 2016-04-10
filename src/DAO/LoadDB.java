package DAO;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;

public class LoadDB {

    public static void main(String[] args) throws IOException {
        //SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory

        FileInputStream in = new FileInputStream(new File("prof03.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(in);
        HSSFSheet set = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        CellReference cellReference = new CellReference("Enseigant");

        /*
        * for(int i=1;i<=set.getLastRowNum();i++)
         {

         }
        * */


        for (Row row : set) {

            for (Cell cell : row) {
                 {
                    String aa = String.valueOf(cell.getDateCellValue());
                    System.out.println("hello world" + aa);
                }
            }
        }
                /*switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.println(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        break;

                }
                System.out.println("");
            }
        }*/
    }


    public LoadDB() throws FileNotFoundException {
    }
}
