package View;

import Model.ProductModel;
import Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
private Scanner scanner=new Scanner(System.in);



    public void launcher() {
        boolean checkAction = false;
        do {
            System.out.println("Menu Product: ");
            System.out.println("Nhập 1. Xem danh sách  ");
            System.out.println("Nhập 2. Thêm sản phẩm");
            System.out.println("Nhập 3. Sửa sản phẩm");
            System.out.println("Nhập 4. Xóa sản phẩm theo ID");
            System.out.println("Nhập 5: Tìm kiếm sản phẩm theo id ");

            String actionMenu = scanner.nextLine();
            switch (actionMenu) {
                case "1" -> {
                    showProduct();
                }
                case "2" -> {
                    insertProduct();
                }
                case "3" -> {
                    editProduct();
                }
                case "4" -> {
                    deleteProduct();
                }
                case "5" -> {
                    searchProduct();
                }
                default -> {return;}
            }
        }while (!checkAction);



    }

    private void editProduct() {
        ProductService productService = new ProductService();
        // Yêu cầu người dùng nhập ID sản phẩm muốn sửa
        System.out.print("Enter the ID of the product you want to update: ");
        int productId =Integer.parseInt(scanner.nextLine()) ;
        // Yêu cầu người dùng nhập thông tin mới cho sản phẩm
        System.out.print("Enter the new name: ");
        String newName =scanner.nextLine();
        System.out.print("Enter the new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter the new price: ");
        double newPrice = scanner.nextDouble();
        // Tạo đối tượng ProductModel mới với thông tin đã nhập
        ProductModel updatedProduct = new ProductModel(productId, newName, newDescription, newPrice);
        // Sửa sản phẩm theo ID
        productService.updateProductById(productId, updatedProduct);
    }


    public void showProduct(){
        ProductService productService = new ProductService();
        List<ProductModel> products = productService.read();
        if (products != null) {
            for (ProductModel product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Failed to read product data from JSON.");
        }
    }

public void insertProduct(){
    ProductService productService = new ProductService();
    // Đọc danh sách sản phẩm từ tệp JSON hiện có
    List<ProductModel> existingProducts = productService.read();
    System.out.print("Enter the number of products: ");
    int numOfProducts = scanner.nextInt();
    List<ProductModel> products = new ArrayList<>();
    for (int i = 0; i < numOfProducts; i++) {
        System.out.println("Enter details for product " + (i + 1) + ":");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        ProductModel product = new ProductModel(id, name, description, price);
        products.add(product);
    }
    // Thêm sản phẩm mới vào danh sách sản phẩm hiện có
    existingProducts.addAll(products);
    // Ghi danh sách sản phẩm vào tệp JSON
    productService.write(existingProducts);
    System.out.println("Data written to product.json successfully.");
}


    public void deleteProduct(){
        ProductService productService = new ProductService();
        // Yêu cầu người dùng nhập ID sản phẩm muốn xóa
        System.out.print("Enter the ID of the product you want to delete: ");
        int productId = scanner.nextInt();
        // Xóa sản phẩm theo ID
        productService.deleteProductById(productId);
    }
    public void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        System.out.print("Enter the ID of the product you want to search: ");
        int productId = scanner.nextInt();
        ProductModel product = productService.findProductById(productId);
        if (product != null) {
            System.out.println("Product found:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }






    public static void main(String[] args) {
        ProductView productView=new ProductView();
        productView.launcher();
    }
    }
