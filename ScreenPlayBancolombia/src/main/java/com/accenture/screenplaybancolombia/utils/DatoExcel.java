package com.accenture.screenplaybancolombia.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatoExcel {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    
    public static void setExcelFile(String Path,String SheetName) throws Exception {
          try {
                        // Open the Excel file
                        FileInputStream ExcelFile = new FileInputStream(Path);
                        // Access the required test data sheet
                        ExcelWBook = new XSSFWorkbook(ExcelFile);
                        ExcelWSheet = ExcelWBook.getSheet(SheetName);
          } catch (Exception e){
                        throw (e);
          }

    }
    
    public static String getCellData(int RowNum, int ColNum) throws Exception{

          try{
                 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                 String CellData = Cell.getStringCellValue();
                 return CellData;
                 }catch (Exception e){
                 return"";
                 }

    }


}
