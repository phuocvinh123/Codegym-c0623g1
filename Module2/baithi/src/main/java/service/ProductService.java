package service;

import model.ProductModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.FileUtil;

import java.io.*;
import java.util.*;

import static org.apache.poi.util.HexRead.readData;

public class ProductService {
    private  final String fileProduct = "./data/products.xlsx";


    public void addProductToExcel(ProductModel product, int categoryIndex) {
        try {
            FileInputStream file = new FileInputStream(fileProduct);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            // Xác định dòng tiếp theo để thêm dữ liệu
            int nextRowNum = sheet.getLastRowNum() + 1;
            Row newRow = sheet.createRow(nextRowNum);

            // Thiết lập giá trị cho từng ô trong hàng mới
            Cell cell1 = newRow.createCell(0);
            cell1.setCellValue(product.getId());

            Cell cell2 = newRow.createCell(1);
            cell2.setCellValue(product.getName());

            Cell cell3 = newRow.createCell(2);
            cell3.setCellValue(product.getDescription());

            Cell cell4 = newRow.createCell(3);
            cell4.setCellValue(categoryIndex);

            Cell cell5 = newRow.createCell(4);
            cell5.setCellValue(product.getPrice());

            Cell cell6 = newRow.createCell(5);
            cell6.setCellValue(product.getQuantity());

            // Lưu workbook với dữ liệu mới vào file
            FileOutputStream fileOut = new FileOutputStream(fileProduct);
            workbook.write(fileOut);
            fileOut.close();

            System.out.println("Sản phẩm đã được thêm mới vào file Excel.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<ProductModel> readProductsFromExcel(String filename) {
        List<ProductModel> productList = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Bỏ qua dòng tiêu đề
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            // Lặp qua các hàng (rows)
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Long id = (long) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String description = row.getCell(2).getStringCellValue();
                String category = row.getCell(3).getStringCellValue();
                double price = row.getCell(4).getNumericCellValue();
                int quantity = (int) row.getCell(5).getNumericCellValue();

                ProductModel product = new ProductModel(id, name, description, price,ECategory.valueOf(category)  ,quantity);
                productList.add(product);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }
    public void deleteProductById(String productId) {
        try {
            FileInputStream file = new FileInputStream(new File(fileProduct));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Tìm dòng chứa ID cần xóa
            int rowIndexToDelete = -1;
            for (Row row : sheet) {
                Cell cell = row.getCell(0); // Ô chứa ID
                if (cell.getCellType() == CellType.NUMERIC) {
                    double id = cell.getNumericCellValue();
                    if (id == Double.parseDouble(productId)) {
                        rowIndexToDelete = row.getRowNum();
                        break;
                    }
                }
            }

            // Xóa dòng
            if (rowIndexToDelete >= 0) {
                sheet.removeRow(sheet.getRow(rowIndexToDelete));

                // Dịch các dòng phía sau lên để điền vào khoảng trống
                int lastRowNum = sheet.getLastRowNum();
                if (rowIndexToDelete < lastRowNum) {
                    sheet.shiftRows(rowIndexToDelete + 1, lastRowNum, -1);
                }
            }

            // Ghi lại tệp Excel sau khi xóa
            FileOutputStream fileOut = new FileOutputStream(fileProduct);
            workbook.write(fileOut);
            fileOut.close();

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateProductById(String productId, String newName, String newDescription, String newCategory, double newPrice, int newQuantity) {
        try {
            FileInputStream file = new FileInputStream(new File(fileProduct));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Tìm dòng chứa ID cần sửa đổi
            int rowIndexToUpdate = -1;
            for (Row row : sheet) {
                Cell cell = row.getCell(0); // Ô chứa ID
                if (cell.getCellType() == CellType.NUMERIC) {
                    double id = cell.getNumericCellValue();
                    if (id == Double.parseDouble(productId)) {
                        rowIndexToUpdate = row.getRowNum();
                        break;
                    }
                }
            }

            // Sửa đổi sản phẩm
            if (rowIndexToUpdate >= 0) {
                Row rowToUpdate = sheet.getRow(rowIndexToUpdate);
                Cell nameCell = rowToUpdate.getCell(1); // Ô chứa tên sản phẩm
                Cell descriptionCell = rowToUpdate.getCell(2); // Ô chứa mô tả
                Cell categoryCell = rowToUpdate.getCell(3); // Ô chứa danh mục
                Cell priceCell = rowToUpdate.getCell(4); // Ô chứa giá
                Cell quantityCell = rowToUpdate.getCell(5); // Ô chứa số lượng

                nameCell.setCellValue(newName);
                descriptionCell.setCellValue(newDescription);
                categoryCell.setCellValue(newCategory);
                priceCell.setCellValue(newPrice);
                quantityCell.setCellValue(newQuantity);
            }

            // Ghi lại tệp Excel sau khi sửa đổi
            FileOutputStream fileOut = new FileOutputStream(fileProduct);
            workbook.write(fileOut);
            fileOut.close();

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortExcelDataByPrice() {
        try {
            FileInputStream file = new FileInputStream(new File(fileProduct));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Đọc dữ liệu từ tệp Excel vào danh sách
            List<Row> rows = new ArrayList<>();
            for (Row row : sheet) {
                rows.add(row);
            }

            // Sắp xếp danh sách theo cột "PRICE" (cột 4)
            Collections.sort(rows, new Comparator<Row>() {
                @Override
                public int compare(Row row1, Row row2) {
                    Cell cell1 = row1.getCell(4);
                    Cell cell2 = row2.getCell(4);

                    double price1 = cell1 != null && cell1.getCellType() == CellType.NUMERIC ? cell1.getNumericCellValue() : 0.0;
                    double price2 = cell2 != null && cell2.getCellType() == CellType.NUMERIC ? cell2.getNumericCellValue() : 0.0;

                    return Double.compare(price1, price2);
                }
            });

            // Tạo một bản sao của tệp Excel gốc
            XSSFWorkbook newWorkbook = new XSSFWorkbook();
            XSSFSheet newSheet = newWorkbook.createSheet(sheet.getSheetName());

            // Tạo các dòng mới và thêm dữ liệu đã sắp xếp vào tệp Excel mới
            for (int i = 0; i < rows.size(); i++) {
                Row newRow = newSheet.createRow(i);
                Row originalRow = rows.get(i);
                for (int j = 0; j < originalRow.getLastCellNum(); j++) {
                    Cell newCell = newRow.createCell(j);
                    Cell originalCell = originalRow.getCell(j);
                    if (originalCell != null) {
                        CellType cellType = originalCell.getCellType();
                        switch (cellType) {
                            case STRING:
                                newCell.setCellValue(originalCell.getStringCellValue());
                                break;
                            case NUMERIC:
                                newCell.setCellValue(originalCell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                newCell.setCellValue(originalCell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                newCell.setCellFormula(originalCell.getCellFormula());
                                break;
                            // Xử lý các loại ô khác nếu cần
                            default:
                                break;
                        }
                    }
                }
            }

            // Ghi lại tệp Excel mới sau khi sắp xếp
            FileOutputStream fileOut = new FileOutputStream("./data/newProduct.xlsx");
            newWorkbook.write(fileOut);
            fileOut.close();


            file.close();
            newWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findMaxPriceProduct() {
        try {
            FileInputStream file = new FileInputStream(fileProduct);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            double maxPrice = 0.0;
            String productName = "";

            for (Row row : sheet) {
                Cell priceCell = row.getCell(4);
                if (priceCell != null && priceCell.getCellType() == CellType.NUMERIC) {
                    double price = priceCell.getNumericCellValue();
                    if (price > maxPrice) {
                        maxPrice = price;
                        Cell nameCell = row.getCell(1);
                        if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
                            productName = nameCell.getStringCellValue();
                        }
                    }
                }
            }

            System.out.println("Product with the highest price:");
            System.out.println("Name: " + productName);
            System.out.println("Price: " + maxPrice);

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
