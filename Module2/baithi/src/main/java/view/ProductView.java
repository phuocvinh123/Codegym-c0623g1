package view;

import model.ProductModel;
import service.ECategory;
import service.ProductService;
import util.FileUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private  final String fileProduct = "./data/products.xlsx";
    private ProductService productService;
    private Scanner scanner;
    public ProductView() {
        productService = new ProductService();
        scanner = new Scanner(System.in);
    }


    public void launcher() {
        while (true) {
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║       Trang quản lí sản phẩm               ║");
            System.out.println("                                                           ║      1. Xem sản phẩm                       ║");
            System.out.println("                                                           ║      2. Thêm mới sản phẩm                  ║");
            System.out.println("                                                           ║      3. Thay đổi thông tin sản phẩm        ║");
            System.out.println("                                                           ║      4. Xóa sản phẩm theo id               ║");
            System.out.println("                                                           ║      5. Xắp xếp sản phẩm theo giá          ║");
            System.out.println("                                                           ║      6. Hiển thị giá sản phẩm đắt nhất     ║");
            System.out.println("                                                           ║      0. Thoát                              ║");
            System.out.println("                                                           ╚════════════════════════════════════════════╝");
            String actionMenu = scanner.nextLine();
            switch (actionMenu) {
                case "1" -> {
                    showProductList();
                }
                case "2" -> {
                    addProduct();
                }
                case "3" -> {
                    editProduct();
                }
                case "4" -> {
                    deleteProduct();
                }
                case "5" -> {
                    sortProduct();
                }
                case "6" -> {
                    searchProduct();
                }
                default -> {
                    return;
                }
            }
        }
    }

    private void searchProduct() {
        productService.findMaxPriceProduct();
    }


    public void addProduct() {
        System.out.println("Nhập thông tin sản phẩm mới:");

        // Nhập thông tin từ người dùng
        System.out.print("ID: ");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Mô tả: ");
        String description = scanner.nextLine();

        System.out.print("Danh mục (1. PHONE, 2. LAPTOP): ");
        int categoryIndex = scanner.nextInt();
        ECategory category = null;
        switch (categoryIndex) {
            case 1:
                category = ECategory.PHONE;
                break;
            case 2:
                category = ECategory.LAPTOP;
                break;
            default:
                break;
        }

        System.out.print("Giá: ");
        double price = scanner.nextDouble();

        System.out.print("Số lượng: ");
        int quantity = scanner.nextInt();

        // Tạo đối tượng ProductModel từ thông tin nhập vào
        ProductModel newProduct = new ProductModel(id, name, description, price, category, quantity);

        // Gọi phương thức addProductToExcel() từ ProductService
        productService.addProductToExcel(newProduct,categoryIndex);
    }


    public void deleteProduct(){
        System.out.print("Nhập id bạn muốn xóa: ");
        String id=scanner.nextLine();
        productService.deleteProductById(id);
    }
    public void editProduct(){
        System.out.print("Nhập ID sản phẩm cần sửa đổi: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm mới: ");
        String newDescription = scanner.nextLine();
        System.out.print("Nhập danh mục sản phẩm mới: ");
        String newCategory = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm mới: ");
        double newPrice = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm mới: ");
        int newQuantity = scanner.nextInt();

        ProductService productManager = new ProductService();
        productManager.updateProductById(productId, newName, newDescription, newCategory, newPrice, newQuantity);
    }
    public void sortProduct(){
        while (true){
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║      Bạn muốn sắp xếp theo kiểu nào        ║");
            System.out.println("                                                           ║      Nhập 0. menu                          ║");
            System.out.println("                                                           ║      Nhập 1. Xắp xếp tăng dần              ║");
            System.out.println("                                                           ║      Nhập 2. Hiển thị xắp xếp              ║");
            System.out.println("                                                           ╚════════════════════════════════════════════╝");
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 0:
                    launcher();
                    break;
                case 1:
                    productService.sortExcelDataByPrice();
                    break;
                case 2:
                    showProductList1();
                    break;
            }
        }
    }








    public void showProductList() {
        ProductService productService = new ProductService();
        List<ProductModel> productList = productService.readProductsFromExcel(fileProduct);

        // Hiển thị danh sách sản phẩm
        System.out.println("                                                                             Thông tin sản phẩm   ");
        System.out.println("                             ===========================================================================================================");
        System.out.printf("                             ║ %-5s| %15s |%25s |%15s |%15s |%15s \n","ID","NAME","DESCRIPTION","CATEGORY","PRICE","QUANTITY           ║");
        for (ProductModel product : productList) {
            System.out.printf("                             ║ %-5s| %15s |%25s |%15s |%15s |%15s \n",product.getId(),product.getName(),product.getDescription(), product.getCategory(), product.getPrice(),product.getQuantity()+"                  ║");
        }
        System.out.println("                             ============================================================================================================");
    }
    public void showProductList1() {
        ProductService productService = new ProductService();
        List<ProductModel> productList = productService.readProductsFromExcel("./data/newProduct.xlsx");

        // Hiển thị danh sách sản phẩm
        System.out.println("                                                                             Thông tin sản phẩm   ");
        System.out.println("                             ===========================================================================================================");
        System.out.printf("                             ║ %-5s| %15s |%25s |%15s |%15s |%15s \n","ID","NAME","DESCRIPTION","CATEGORY","PRICE","QUANTITY           ║");
        for (ProductModel product : productList) {
            System.out.printf("                             ║ %-5s| %15s |%25s |%15s |%15s |%15s \n",product.getId(),product.getName(),product.getDescription(), product.getCategory(), product.getPrice(),product.getQuantity()+"                  ║");
        }
        System.out.println("                             ============================================================================================================");
    }




    public static void main(String[] args) {
        ProductView p=new ProductView();
        p.sortProduct();
    }
}
