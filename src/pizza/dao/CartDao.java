package pizza.dao;

import java.util.List;

import pizza.pojo.Cart;

public interface CartDao
{
    public boolean addToCart(Cart c);
    public boolean deleteCart(String username);
    public boolean deleteCartById(int cartId,int pizzaId);
    public boolean updateCart(int pizzaId,String username,String quantity,String price,String size);
    public List<Cart> getCart(String username);
    public boolean alreadyAvailableInCart(int pizzaId,String username,String size);
    public String getPreviousQuantityFromCart(int pizzaId,String username, String size);
    public String totalPriceInCart(String username);
}
