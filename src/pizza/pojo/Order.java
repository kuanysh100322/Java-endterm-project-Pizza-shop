package pizza.pojo;

public class Order
{
    private int orderId;
    private String username,pizzaName,size,quantity,price,date;
    
    
     
	public Order() {
		
	}

	
	
	public Order(String username, String pizzaName, String size, String quantity, String price, String date) {
		super();
		this.username = username;
		this.pizzaName = pizzaName;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}



	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
	
    
}
