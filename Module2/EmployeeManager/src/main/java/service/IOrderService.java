package service;

import model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    Order findOrder(long id);

    void updateOrder(long id, Order order);

    void deleteOrder(long id);

    void createOrder(Order Order);
}
