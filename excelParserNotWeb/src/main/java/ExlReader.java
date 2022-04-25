import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ExlReader {

    private HashMap <Integer, List<Object>> data = new HashMap<>();

    public HashMap<Integer, List<Object>> getData() {
        return data;
    }

    public void read(String filename) throws IOException {
        Workbook workbook = getWorkBook(filename);
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            processSheet(sheet);
            System.out.println();
        }
    }

    private Workbook getWorkBook(String filePath) throws IOException {

        String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        switch (fileExtension) {
            case "xls":
                return new HSSFWorkbook(file);
            case "xlsx":
                return new XSSFWorkbook(file);
            default:
                throw new RuntimeException("Unknown Excel file extension: " + fileExtension);
        }
    }

    private void processSheet(Sheet sheet) {
        System.out.println("Sheet: " + sheet.getSheetName());
        Iterator<Row> iterator = sheet.rowIterator();
        for (int rowIndex = 0; iterator.hasNext(); rowIndex++) {
            Row row = iterator.next();
            processRow(data, rowIndex, row);
        }
    }

    private void processRow(HashMap<Integer, List<Object>> data, int rowIndex, Row row) {
        data.put(rowIndex, new ArrayList<>());
        for (Cell cell : row) {
            processCell(cell, data.get(rowIndex));
        }
    }

    private void processCell(Cell cell, List<Object> dataRow) {
        switch (cell.getCellTypeEnum()) {
            case STRING:
                dataRow.add(cell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    dataRow.add(cell.getDateCellValue());
                } else {
                    dataRow.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                dataRow.add(cell.getBooleanCellValue());
                break;
            case FORMULA:
                dataRow.add(cell.getCellFormula());
                break;
        }
    }

}
