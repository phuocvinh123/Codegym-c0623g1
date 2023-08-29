package views;

import model.ECategory;
import model.Product;
import service.IProductService;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private IProductService iProductService;

    public ProductView() {
        iProductService = new ProductService();
    }
    public void launcher() {
        boolean checkAction = false;
        do {
            System.out.println("Menu quản lý Sản phẩm: ");
            System.out.println("Nhập 1. Xem danh sách ");
            System.out.println("Nhập 2. Thêm product");
            System.out.println("Nhập 3. Sửa product");
            System.out.println("Nhập 4. Xóa product theo ID");
            System.out.println("Nhập 5: Sắp xếp theo (Vào trong chọn thêm menu: tên/giá/category + TĂNG DẦN/GIẢM DẦN) ");
            System.out.println("Nhập 6: Tìm kiếm theo tên");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1: {
                    showProduct();
                    break;
                }
                case 2: {
                    addProduct();
                    break;
                }
            }
        }while (!checkAction);
    }

    private void sortProduct() {
        System.out.println("Sắp xếp theo");
        System.out.println("Nhập 1. Sắp xếp theo tên");
        System.out.println("Nhập 2. Sắp xếp theo tuổi");
        System.out.println("Nhập 3. Sắp xếp theo \"dd-MM-yyyy\"");
        int select = Integer.parseInt(scanner.nextLine());
        switch (select){
            case 1: {
//                            sortName();
                break;
            }
            case 2: {
//                            sortAge();
                break;
            }
            case 3: {
//                            sortDate();
                break;
            }
        }
    }

    private void addProduct() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập description:");
        String description = scanner.nextLine();
        System.out.println("Nhập price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập thể loại: ");
        for (ECategory eCategory : ECategory.values()) {
            System.out.println(eCategory.getName() + " : " + eCategory.getId());
        }
        int iCategory = Integer.parseInt(scanner.nextLine());
        ECategory category = ECategory.findById(iCategory);

        Product product = new Product(System.currentTimeMillis()%100000, name, description, price, category);

        iProductService.createProduct(product);

        showProduct();
    }

    private void showProduct() {
        System.out.printf("%10s | %20s | %30s | %20s | %10s \n", "ID", "Name", "DESCRIPTION", "PRICE", "CATEGORY");
        List<Product> products = iProductService.getAllProducts();
        for (Product p : products) {
            System.out.printf("%10s | %20s | %30s | %20s | %10s \n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getCategory());
        }
    }

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        productView.launcher();
    }
}
