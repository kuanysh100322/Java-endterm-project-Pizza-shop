package pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pizza.DButility.DBUtility;
import pizza.pojo.Admin;

public class AdminDaoImp implements AdminDao
{
	PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    int row=0,count=0;

	@Override
	public boolean addAdmin(Admin admin)
	{
		Connection con=DBUtility.getConnection();
		String query="insert into adminlogin(Name,Phone, Address, Password ) Values(?,?,?,?) ";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getContact());
			pstmt.setString(3, admin.getAddress());
			pstmt.setString(4, admin.getPassword());
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
		 
		String query="select * from adminlogin";
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
	public boolean updateAdmin(Admin admin) 
	{
		Connection con=DBUtility.getConnection();
		String query="update adminLogin set Phone=?,Address=? where Id=?";
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,admin.getContact());
			pstmt.setString(2, admin.getAddress());
			pstmt.setInt(3, admin.getId());
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
	public boolean deleteAdmin(int id)
	{
		Connection con=DBUtility.getConnection();
		String query="delete from adminlogin  where Id=?";
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
	public Admin getAdmin(String username) 
	{
		Connection con=DBUtility.getConnection();
		Admin admin=new Admin();
		 
		String query="select * from adminlogin where Name='"+username+"'";
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				admin.setName(rs.getString("Name"));
				admin.setId(rs.getInt("Id"));
				admin.setAddress(rs.getString("Address"));
				admin.setContact(rs.getString("Phone"));
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

        return admin;
	}
	
	@Override
	public boolean forgotPassword(String username,String phoneNumber, String password)
	{
		Connection con=DBUtility.getConnection();
		String query="update adminlogin set Password=? where Name=? and Phone=?";
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
		String query="update adminLogin set Password=? where Name=?";
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

}
