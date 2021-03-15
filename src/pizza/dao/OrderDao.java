package pizza.dao;

import java.util.List;

import pizza.pojo.Order;

public interface OrderDao
{
    public boolean addOrder(Order order);
    public List<Order> getOrder(String username);
    public List<Order> getAllOrder();
    public String totalOrderPrice(String username);
}
