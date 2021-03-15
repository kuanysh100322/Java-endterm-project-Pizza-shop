package pizza.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pizza.DButility.DBUtility;
import pizza.pojo.Pizza;

public class PizzaDaoImp implements PizzaDao
{
	PreparedStatement stmt;
    ResultSet rs;
    int row=0,count=0;
	
	@Override
	public boolean addPizza(Pizza pizza)
	{
		Connection con=DBUtility.getConnection();
		
		String query="insert into Pizza(name,category,description,sprice,mprice,lprice,image) Values(?,?,?,?,?,?,?)";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, pizza.getName());
			stmt.setString(2, pizza.getCategory());
			stmt.setString(3, pizza.getDescription());
			stmt.setString(4, pizza.getSprice());
			stmt.setString(5, pizza.getMprice());
			stmt.setString(6, pizza.getLprice());
			stmt.setString(7,pizza.getImage());
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
	public boolean updatePizza(Pizza pizza)
	{
		Connection con=DBUtility.getConnection();
		
		
		String query="update Pizza set name=?,category=?,description=?,sprice=?,mprice=?,lprice=?,image=? where id=?";
		     
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, pizza.getName());
			stmt.setString(2, pizza.getCategory());
			stmt.setString(3, pizza.getDescription());
			stmt.setString(4, pizza.getSprice());
			stmt.setString(5, pizza.getMprice());
			stmt.setString(6, pizza.getLprice());
			stmt.setString(7,pizza.getImage());
			stmt.setInt(8,pizza.getId());
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
	public boolean deletePizza(int id)
	{
		Connection con=DBUtility.getConnection();
		
		String query="delete from Pizza where id=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setInt(1,id);
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
	public Pizza getPizza(int id)
	{
		Connection con=DBUtility.getConnection();
		Pizza p = null;
		String query="select * from Pizza where id=?";
		try
		{
			stmt=con.prepareStatement(query);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				p= new Pizza();
				p.setId(id);
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setDescription(rs.getString("description"));
				p.setSprice(rs.getString("sprice"));
				p.setMprice(rs.getString("mprice"));
				p.setLprice(rs.getString("lprice")); 
				p.setImage(rs.getString("image"));
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return p;
	}

	@Override
	public List<Pizza> getAllPizza()
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select * from Pizza";
		Pizza p = null;
		List<Pizza> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);  // we will be having every thing in this rs object.
			while(rs.next())
			{
				p= new Pizza();                                       // 1) Kaz pizza 2)Mine pizza
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setDescription(rs.getString("description"));
				p.setSprice(rs.getString("sprice"));
				p.setMprice(rs.getString("mprice"));
				p.setLprice(rs.getString("lprice")); 
				p.setImage(rs.getString("image"));
				//****
		        li.add(p);                                            // LIST[Kaz Pizza,Mine pizza]
		  	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;

	}

	

}
