package pizza.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizza.dao.AdminDaoImp;
import pizza.dao.CustomerDaoImp;
import pizza.pojo.Admin;
import pizza.pojo.Customer;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		
		if(action.equals("logout"))
		{
			HttpSession session=request.getSession();
			RequestDispatcher rd;
			session.invalidate();
			String statusString="<span id='Success'><b>Successfully Logged Out.....</b></span>";
			request.setAttribute("status",statusString);
			rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		RequestDispatcher rd;
		HttpSession session=request.getSession();
		String type=request.getParameter("type");  // we r just fetching the values from jsp page using the attribute name
		String action=request.getParameter("action");
		
		boolean flag=false;
		
		
		if(type.equals("Customer") && action.equals("signUp"))
		{
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String pass=request.getParameter("password");
			Customer customer=new Customer(name, phone, address, pass);
			CustomerDaoImp cd=new CustomerDaoImp();
			flag=cd.addCustomer(customer);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success' >Successfully registered as <b>"+name+"</b> .</span>");
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to Sign Up.</span>");
				rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Customer") && action.equals("login"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("password");
			CustomerDaoImp cd=new CustomerDaoImp();
			flag=cd.login(name, pass);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Successfully Logged in as <b>"+name+"</b> .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
				session.setAttribute("username", name);
				session.setAttribute("usertype", "CUSTOMER");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to Login, Please try again...</span>");
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		
		if(type.equals("Admin") && action.equals("signUp"))
		{
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String pass=request.getParameter("password");
			Admin admin=new Admin(name, phone, address, pass);
			AdminDaoImp ad=new AdminDaoImp();
			flag=ad.addAdmin(admin);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Successfully registered as <b>"+name+"</b> .</span>");
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to Sign Up.</span>");
				rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Admin") && action.equals("login"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("password");
			AdminDaoImp ad=new AdminDaoImp();
			flag=ad.login(name, pass);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Successfully Logged in as <b>"+name+"</b> .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
				session.setAttribute("username", name);
				session.setAttribute("usertype", "ADMIN");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to Login, Please try again...</span>");
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Admin") && action.equals("forgotPassword"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String contact=request.getParameter("contact");
			
			AdminDaoImp ad=new AdminDaoImp();
			flag=ad.forgotPassword(name,contact, password);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Password changed successfuly .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
		        rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to change password. </span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Customer") && action.equals("forgotPassword"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String contact=request.getParameter("contact");
			
			CustomerDaoImp cd=new CustomerDaoImp();
			flag=cd.forgotPassword(name,contact, password);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Password changed successfuly .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
		        rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to change password. </span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Admin") && action.equals("changePassword"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
		
			
			AdminDaoImp ad=new AdminDaoImp();
			flag=ad.changePassword(name, password);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Password changed successfuly .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
		        rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to change password. </span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(type.equals("Customer") && action.equals("changePassword"))
		{
			System.out.println("enetered");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
		    System.out.println(name + password);
			
			CustomerDaoImp cd=new CustomerDaoImp();
			flag=cd.changePassword(name,password);
			if(flag==true)
			{
				request.setAttribute("status","<span id='Success'>Password changed successfuly .</span> ");
				rd=request.getRequestDispatcher("Home.jsp");
		        rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("status","<span id='Fail'>Failed to change password. </span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
