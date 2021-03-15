package pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pizza.DButility.DBUtility;
import pizza.pojo.Customer;
import pizza.pojo.Order;

public class CustomerDaoImp implements CustomerDao
{
	PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    int row=0,count=0;
	
	@Override
	public boolean addCustomer(Customer customer)
	{
		Connection con=DBUtility.getConnection();
		String query="insert into login(Name,Phone, Address, Password ) Values(?,?,?,?) ";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,customer.getName());
			pstmt.setString(2,customer.getContact());
			pstmt.setString(3,customer.getAddress());
			pstmt.setString(4,customer.getPassword());
			row=pstmt.executeUpdate();
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
	public boolean login(String name, String password)
	{
		Connection con=DBUtility.getConnection();
		String uname, upassword;
		 
		String query="select * from login";
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				uname=rs.getString("Name");          // data from database
				upassword=rs.getString("Password");
				
				if(uname.equals(name) && upassword.equals(password))
				{
					count =1;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

        if(count==1)
        {
        	count=0;
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	@Override
	public boolean updateCustomer(Customer customer) 
	{
		Connection con=DBUtility.getConnection();
		String query="update login set Phone=?,Address=? where Id=?";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,customer.getContact());
			pstmt.setString(2, customer.getAddress());
			pstmt.setInt(3, customer.getId());
			row=pstmt.executeUpdate();
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
	public boolean deleteCustomer(int id)
	{
		Connection con=DBUtility.getConnection();
		String query="delete from login  where Id=?";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			row=pstmt.executeUpdate();
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
	public Customer getCustomer(String username) 
	{
		Connection con=DBUtility.getConnection();
		Customer customer=new Customer();
		 
		String query="select * from login where Name='"+username+"'";
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				customer.setName(rs.getString("Name"));
				customer.setId(rs.getInt("Id"));
				customer.setAddress(rs.getString("Address"));
				customer.setContact(rs.getString("Phone"));
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

        return customer;
	}

	@Override
	public boolean forgotPassword(String username,String phoneNumber, String password)
	{
		Connection con=DBUtility.getConnection();
		String query="update login set Password=? where Name=? and Phone=?";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,password);
			pstmt.setString(2,username);
			pstmt.setString(3,phoneNumber);
			row=pstmt.executeUpdate();
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
	public boolean changePassword(String username, String newPassword)
	{
		Connection con=DBUtility.getConnection();
		String query="update login set Password=? where Name=?";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,newPassword);
			pstmt.setString(2,username);
			row=pstmt.executeUpdate();
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
	public List<Customer> getAllCustomer()
	{
		Connection con=DBUtility.getConnection();
		Statement stmt;
		String query="select * from login";
		Customer customer = null ;
		List<Customer> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				customer=new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setContact(rs.getString("Phone"));
				customer.setAddress(rs.getString("Address"));
		        li.add(customer);                                           	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;
	}
	
}
