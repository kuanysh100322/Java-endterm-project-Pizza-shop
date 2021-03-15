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

public class CartDaoImp implements CartDao
{
	
	PreparedStatement stmt;
    ResultSet rs;
    int row=0,count=0;

	@Override
	public boolean addToCart(Cart c)
	{
        Connection con=DBUtility.getConnection();
		
		String query="insert into Cart(pizzaId,quantity,size,name,price) Values(?,?,?,?,?)";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setInt(1, c.getPizzaId());
			stmt.setString(2, c.getQuantity());
			stmt.setString(3, c.getSize());
			stmt.setString(4, c.getName());
			stmt.setString(5, c.getPrice());
			
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
	public boolean deleteCart(String username)
	{
        Connection con=DBUtility.getConnection();
		
		String query="delete from Cart where name=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1,username);
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
	public boolean deleteCartById(int cartId,int pizzaId)
	{
        Connection con=DBUtility.getConnection();
		
		String query="delete from Cart where cartId=? and pizzaId=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setInt(1,cartId);
			stmt.setInt(2,pizzaId);
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
	public boolean updateCart(int pizzaId,String username,String quantity,String price,String size) 
	{
        Connection con=DBUtility.getConnection();
    
		String query="update Cart set quantity=?,price=? where pizzaId=? and name=? and size=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, quantity);
			stmt.setString(2, price);
			stmt.setInt(3, pizzaId);
			stmt.setString(4,username);
			stmt.setString(5, size);
			
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
	public List<Cart> getCart( String username)
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select * from Cart where name='"+username+"'";
		Cart c = null;
		List<Cart> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				c= new Cart();                                    
				c.setCartId(rs.getInt("cartId"));
				c.setPizzaId(rs.getInt("pizzaId"));
				c.setQuantity(rs.getString("quantity"));
				c.setSize(rs.getString("size"));
				c.setName(rs.getString("name"));
				c.setPrice(rs.getString("price"));
				
		        li.add(c);                                         
		  	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;
	}

	@Override
	public boolean alreadyAvailableInCart(int pizzaId,String username,String size)
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		int count=0;
		String query="select * from Cart where name='"+username+"' and pizzaId="+pizzaId+" and size='"+size+"'";
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			if (rs.next() == false)  // result set is empty
			{ 
				count=1; 
			}
			
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		if(count==1)
		{
			return false;
		}	
		
		else
		{
			return true;
		}
		
		
	}

	@Override
	public String getPreviousQuantityFromCart(int pizzaId, String username,String size)
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select quantity from Cart where name='"+username+"' and pizzaId="+pizzaId+" and size='"+size+"'";
		String quantity=null;
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			
			while(rs.next())
			{
				quantity=rs.getString("quantity");
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return quantity;
	}

	@Override
	public String totalPriceInCart(String username) 
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		int price=0;
		String query="select price from Cart where name='"+username+"'";
		
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
	
	
	
	

}
