package pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizza.DButility.DBUtility;
import pizza.pojo.Cart;
import pizza.pojo.Order;

public class OrderDaoImp implements OrderDao
{
	PreparedStatement stmt;
    ResultSet rs;
    int row=0,count=0;
	
	@Override
	public boolean addOrder(Order order)
	{
        Connection con=DBUtility.getConnection();
		
		String query="insert into Orders(username,pizzaName,size,quantity,price,date) Values(?,?,?,?,?,?)";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, order.getUsername());
			stmt.setString(2, order.getPizzaName());
			stmt.setString(3, order.getSize());
			stmt.setString(4, order.getQuantity());
			stmt.setString(5, order.getPrice());
			stmt.setString(6, order.getDate());
		    row=stmt.executeUpdate();
		} 
		catch (SQLException e)
		{	
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public String totalOrderPrice(String username)
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		int price=0;
		String query="select price from Orders where username='"+username+"'";
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			
			while(rs.next())
			{
				int p=Integer.parseInt(rs.getString("price"));
				price=price+p;
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		String totalPrice=String.valueOf(price);
		return totalPrice;
	}

	@Override
	public List<Order> getOrder(String username)
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select * from Orders where username='"+username+"'";
		Order order = null ;
		List<Order> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				order=new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setPizzaName(rs.getString("pizzaName"));
				order.setPrice(rs.getString("price"));
				order.setQuantity(rs.getString("quantity"));
				order.setSize(rs.getString("size"));
				order.setUsername(rs.getString("username"));
				order.setDate(rs.getString("date"));
		        li.add(order);                                         
		  	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;
	}

	@Override
	public List<Order> getAllOrder()
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select * from Orders";
		Order order = null ;
		List<Order> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				order=new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setPizzaName(rs.getString("pizzaName"));
				order.setPrice(rs.getString("price"));
				order.setQuantity(rs.getString("quantity"));
				order.setSize(rs.getString("size"));
				order.setUsername(rs.getString("username"));
				order.setDate(rs.getString("date"));
		        li.add(order);                                         
		  	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;
	}
    
}
