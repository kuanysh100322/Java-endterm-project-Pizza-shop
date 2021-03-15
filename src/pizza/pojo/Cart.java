package pizza.pojo;

public class Cart
{
    private int cartId,pizzaId;
    private String name,quantity,size,price;
    
    public Cart()
    {
    	
    }
    
	public Cart(int pizzaId, String name, String quantity, String size, String price) {
		super();
		this.pizzaId = pizzaId;
		this.name = name;
		this.quantity = quantity;
		this.size = size;
		this.price = price;
	}



	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
    
    
    
}
