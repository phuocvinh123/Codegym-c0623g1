package service;

import model.OrderItem;
import utils.FileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemService implements IOrderItemService{
    private final String fileOrderItem = "./data/order_details.txt";
    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = FileUtils.readData(fileOrderItem, OrderItem.class);
        return orderItems;
    }

    @Override
    public List<OrderItem> getAllOrderItemsByOrderId(long idOrder) {
        List<OrderItem> orderItems = getAllOrderItems();

        /**
         List<OrderItem> results = new ArrayList<>();
         for (OrderItem item : orderItems) {
         if (item.getIdOrder() == idOrder) {
         results.add(item);
         }
         }
         **/

        List<OrderItem> results = orderItems.stream()
                .filter(orderItem -> orderItem.getIdOrder() == idOrder)
                .collect(Collectors.toList());
        return results;
    }

    @Override
    public OrderItem findOrderItem(long id) {
        return null;
    }

    @Override
    public void updateOrderItem(long id, OrderItem OrderItem) {

    }

    @Override
    public void deleteOrderItem(long id) {

    }

    @Override
    public void createOrderItem(OrderItem orderItem) {
        List<OrderItem> orderItems = getAllOrderItems();
        orderItems.add(orderItem);
        FileUtils.writeData(fileOrderItem, orderItems);

    }
}
