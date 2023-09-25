package util;


    import model.ProductModel;
    import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import service.ECategory;

    import java.io.*;
    import java.util.*;

public class FileUtil {

// đọc trên 1 hàng
        public void readData(String filename) {
            try {
                FileInputStream file = new FileInputStream(new File(filename));

                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);

                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);

                //Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {

                    Row row = rowIterator.next();

                    //For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {

                        Cell cell = cellIterator.next();

                        //Check the cell type and format accordingly
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                System.out.print(cell.getNumericCellValue() + " ");
                                break;
                            case STRING:
                                System.out.print(cell.getStringCellValue() + " ");
                                break;
                        }
                    }
                    System.out.println("");
                }
                file.close();
            } catch (FileNotFoundException fileNotFoundException) {

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

//đọc trên 1 cột
        public void readDataUseFor(){
            try{
                FileInputStream file = new FileInputStream(new File("./data/products.xlsx"));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);

                // Lặp qua các hàng (rows)
                for (Row row : sheet) {
                    // Lặp qua các ô (cells) trong hàng
                    for (Cell cell : row) {
                        // Đọc giá trị từ ô và in ra màn hình
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println(); // Xuống dòng sau mỗi hàng
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

