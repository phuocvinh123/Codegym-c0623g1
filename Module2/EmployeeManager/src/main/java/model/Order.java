package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.DateUtils;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements  IParseModel<Order>{
    private long id;
    private LocalDate createAt;
    private double total;

//    private long idUser;      // có thể lưu thông tin người dùng bằng ID USER

    private String address;
    private String phone;
    private String fullName;
    List<OrderItem> orderItems;

    private EStatus status;

    Order(long id, LocalDate createAt, double total, String address, String phone, String fullName, List<OrderItem> orderItems){id = id;
        this.id = id;
        this.createAt = createAt;
        this.total = total;
        this.address = address;
        this.phone = phone;
        this.fullName = fullName;
        this.orderItems = orderItems;
    }
    @Override
    public Order parse(String line) {
        Order order = null;
        // line : 10044,23-08-2023,8000,Thang Trong,0399578133,Huyen Khong Son Thuong
        String[] items = line.split(",");
//        Order(long id, LocalDate createAt, double total, String address, String phone, String fullName, List<OrderItem> orderItems)
        try {
            order  = new Order(Long.parseLong(items[0]), DateUtils.parseDate(items[1]), Double.parseDouble(items[2]),
                    items[5], items[4], items[3], null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public void setTotalPrice() {
        double total = 0;
        if (this.getOrderItems() != null) {
            for (OrderItem ot : this.getOrderItems()) {
                total += ot.getQuantity() * ot.getPrice();
            }
        }
        this.total = total;

    }

    @Override
    public String toString() {
        //10044,23-08-2023,8000,Thang Trong,0399578133,Huyen Khong Son Thuong
        return String.format("%s,%s,%s,%s,%s,%s", this.id, DateUtils.formatDate(this.createAt), this.total,
                this.fullName, this.phone, this.address
        );
    }
}
