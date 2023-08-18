/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author avecias date: Aug 3, 2023 1:04:17 PM
 */
public class LeerCatCfdi {

    public static double numerico(Cell cell) {
        double valor = 0.0;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    valor = cell.getNumericCellValue();
                    break;
                default:
                    break;
            }
        }
        return valor;
    }

    public static String cadena(Cell cell, DecimalFormat df) {
        String valor = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    valor = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    valor = "" + df.format(cell.getNumericCellValue());
                    break;
                default:
                    valor = "";
                    break;
            }
        }
        return valor;
    }

    public static Date fecha(Cell cell) {
        Date valor = new Date();
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    valor = cell.getDateCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    valor = cell.getDateCellValue();
                    break;
            }
        }
        return valor;
    }

    public static Boolean cadenaBoolean(Cell cell) {
        Boolean valor = Boolean.FALSE;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    valor = cell.getStringCellValue().equals("S");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    valor = cell.getBooleanCellValue();
                    break;
                default:
                    break;
            }
        }
        return valor;
    }

    public static Boolean isBoolean(Cell cell) {
        Boolean valor = Boolean.FALSE;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    valor = cell.getBooleanCellValue();
                    break;
                default:
                    break;
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        FileInputStream fis = null;
        DecimalFormat df = new DecimalFormat("###############");
        DecimalFormat df2 = new DecimalFormat("00");
        int[] index = {4, 4, 4, 4, 4, 5, 6, 4, 4, 4,
            5, 4, 4, 4, 4, 4, 4, 4, 4, 4,
            4, 4, 4, 4, 4, 4, 4, 4};
        StringBuilder sb = new StringBuilder();
        try {
            File myFile = new File("/Users/avecias/Downloads/catCFDI_V_4_29062023.xls");
            fis = new FileInputStream(myFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            // sacar los titulos de cada hoja
            System.out.println(workbook.getActiveSheetIndex());
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            int contSheet = 0;
            while (sheetIterator.hasNext()) {
                Sheet sheet = sheetIterator.next();
                System.out.println("index " + contSheet + ", valor " + index[contSheet]);
                Iterator<Row> rowIterator = sheet.iterator();
                // offset para filas que no nos interesa
                System.out.println("numero de filas: " + sheet.getPhysicalNumberOfRows() + ", de la hoja " + sheet.getSheetName());
                sb.append(sheet.getSheetName()).append("\n");
                int contRow = 0;
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    contRow++;
                    if (contRow <= index[contSheet]) {
                        continue;
                    }
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String value = cadena(cell, df2);
                        value = StringUtils.stripAccents(value);
                        value = CaseUtils.toCamelCase(value, false, ' ');
                        System.out.print(value + ",");
                        sb.append("private final String ").append(value).append(";\n");
                    }
                    System.out.println();
                    break;
                    //
                }
                contSheet++;
            }
            // fin de la lectura
            System.out.println(sb.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerCatCfdi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerCatCfdi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(LeerCatCfdi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
