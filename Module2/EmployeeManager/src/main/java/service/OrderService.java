package service;

import model.Order;
import model.OrderItem;
import utils.FileUtils;

import java.util.List;

public class OrderService implements IOrderService{
    private final String fileOrder = "./data/orders.txt";
    private IOrderItemService iOrderItemService ;

    public OrderService() {
        iOrderItemService = new OrderItemService();
    }
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = FileUtils.readData(fileOrder, Order.class);
        /**
         for (Order o : orders) {
         List<OrderItem> orderItems = iOrderItemService.getAllOrderItemsByOrderId(o.getId());
         o.setOrderItems(orderItems);

         }
         **/
        orders.stream().forEach(order -> {
            List<OrderItem> orderItems = iOrderItemService.getAllOrderItemsByOrderId(order.getId());
            order.setOrderItems(orderItems);
        });

        return orders;
    }

    @Override
    public Order findOrder(long id) {
        List<Order> orders = getAllOrders();
        /**
         for (Order o : orders) {
         if (o.getId() == id) {
         return o;
         }
         }
         **/
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateOrder(long id, Order order) {

    }

    @Override
    public void deleteOrder(long id) {

    }

    @Override
    public void createOrder(Order order) {
        List<Order> orders = getAllOrders();
        orders.add(order);

        FileUtils.writeData(fileOrder, orders);

        // Lưu thêm bên orderItem

        for (OrderItem ot : order.getOrderItems()) {
            iOrderItemService.createOrderItem(ot);
        }
    }
}
