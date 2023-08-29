package service;

import model.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItem> getAllOrderItems();

    List<OrderItem> getAllOrderItemsByOrderId(long idOrder);

    OrderItem findOrderItem(long id);

    void updateOrderItem(long id, OrderItem OrderItem);

    void deleteOrderItem(long id);

    void createOrderItem(OrderItem OrderItem);
}
