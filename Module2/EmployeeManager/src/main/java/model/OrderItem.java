package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements IParseModel<OrderItem>{
    private long id;
    private long idOrder;
    private long idProduct;
    private int quantity;
    private double price;

    @Override
    public OrderItem parse(String line) {
        // line: 15043,10043,20045,1,10000.0
        String[] items = line.split(",");
        OrderItem orderItem = null;
        //public OrderItem(long id,long idOrder,long idProduct,int quantity,double price )
        try {
            orderItem  = new OrderItem(Long.parseLong(items[0]), Long.parseLong(items[1]),
                    Long.parseLong(items[2]), Integer.parseInt(items[3]), Double.parseDouble(items[4]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public String toString() {
        //15045,10044,20045,1,8000.0
        return String.format("%s,%s,%s,%s,%s", this.id, this.idOrder, this.idProduct, this.quantity, this.price);
    }
}
