package views;

import model.Order;
import model.OrderItem;
import model.Product;
import service.IOrderService;
import service.IProductService;
import service.OrderService;
import service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private IOrderService iOrderService;
    private IProductService iProductService;
    public OrderView() {
        iOrderService = new OrderService();
        iProductService = new ProductService();
    }
    public void launcher() {
        boolean checkAction = false;
        do {
            System.out.println("Menu quản lý order: ");
            System.out.println("Nhập 1. Xem danh sách ");
            System.out.println("Nhập 2. Thêm order");
            System.out.println("Nhập 3. Sửa order");
            System.out.println("Nhập 4. Xóa order theo ID");
            System.out.println("Nhập 5. Xem order theo ID ");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1: {
                    showOrders();
                    break;
                }
                case 2:
                {
                    createOrder();
                    break;
                }
                case 5: {
                    showOrderById();
                    break;
                }
            }
        }while (!checkAction);
    }

    private void createOrder() {
        Order order = new Order();
        order.setId(System.currentTimeMillis() % 100000);

        boolean checkContinueOrderItem = false;
        do{
            System.out.println("Nhập ID sản phẩm: ");
            long idProduct = Long.parseLong(scanner.nextLine());
            Product p = iProductService.findProduct(idProduct);

            System.out.println("Nhập số lượng:");
            int quantity = Integer.parseInt(scanner.nextLine());


            if (order.getOrderItems() == null) {
                List<OrderItem> orderItems = new ArrayList<>();

                OrderItem orderItem = new OrderItem(System.currentTimeMillis()%100000,
                        order.getId(), idProduct, quantity, p.getPrice());
                orderItems.add(orderItem);
                order.setOrderItems(orderItems);
            }else{
                if (checkProductExistsInOrder(idProduct, order)) {
                    for (OrderItem ot : order.getOrderItems()) {
                        if (ot.getIdProduct() == idProduct) {
                            ot.setQuantity(quantity);
                        }
                    }

                }else{
                    // Nếu chưa có trong orderItem
                    OrderItem orderItem = new OrderItem(System.currentTimeMillis()%100000,
                            order.getId(), idProduct, quantity, p.getPrice());
                    order.getOrderItems().add(orderItem);
                }
            }
            System.out.println("Bạn có muốn thêm tiếp sản phẩm không: Y/N");
            String actionContinueOrderItem = scanner.nextLine();
            switch (actionContinueOrderItem) {
                case "Y" -> {
                    checkContinueOrderItem = true;
                }
                case "N" -> {
                    checkContinueOrderItem = false;
                }
            }
        }while (checkContinueOrderItem);

        System.out.println("Nhập tên khách hàng:");
        String fullName = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phone = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        order.setPhone(phone);
        order.setFullName(fullName);
        order.setAddress(address);
        order.setTotalPrice();
        order.setCreateAt(LocalDate.now());

        iOrderService.createOrder(order);




    }

    public boolean checkProductExistsInOrder(long idProduct, Order order) {
        if (order.getOrderItems() == null) {
            return false;
        }else{
            for (OrderItem ot : order.getOrderItems()) {
                if (ot.getIdProduct() == idProduct) {
                    return true;
                }
            }
        }
        return false;
    }
    private void showOrderById() {
        System.out.println("Nhập ID order");
        long idOrder = Long.parseLong(scanner.nextLine());
        Order order = iOrderService.findOrder(idOrder);

        System.out.println("MÃ HÓA ĐƠN: " + order.getId());
        System.out.println("FullName: " + order.getFullName());
        System.out.println("Address:  " + order.getAddress());

        System.out.printf("%-20s | %10s | %10s \n", "Product", "Quantity", "Price");
        for (OrderItem ot : order.getOrderItems()) {
            Product p = iProductService.findProduct(ot.getIdProduct());
            System.out.printf("%-20s | %10s | %10s\n", p.getName(), ot.getQuantity(), ot.getQuantity()*ot.getPrice());
        }

        System.out.printf("%-20s   %10s   %10s \n", "", "", order.getTotal());
    }

    private void showOrders() {
        //10044,23-08-2023,8000,Thang Trong,0399578133,Huyen Khong Son Thuong
        List<Order> orders = iOrderService.getAllOrders();
        System.out.printf("%10s | %20s | %20s | %30s | %20s | %10s \n", "ID", "FULLNAME", "PHONE", "ADDRESS", "CREATEAT", "TOTAL");
        for (Order order : orders) {
            System.out.printf("%10s | %20s | %20s | %30s | %20s | %10s \n",
                    order.getId(), order.getFullName(), order.getPhone(),
                    order.getAddress(), order.getCreateAt(), order.getTotal());
        }
    }

    public static void main(String[] args) {
        OrderView orderView = new OrderView();
        orderView.launcher();
    }
}
