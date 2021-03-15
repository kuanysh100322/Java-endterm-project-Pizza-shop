<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="pizza.dao.*"%>
    <%@ page import ="pizza.pojo.*"%>
    <%@ page import="java.util.*" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
       #myprofileTable
       {
             margin-top:100px ;
             margin-left:510px;
       }
</style>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String username=(String)session.getAttribute("username");
    String usertype=(String)session.getAttribute("usertype");
    Customer customer=new Customer();
    Admin admin=new Admin();
    
    if(usertype.equals("CUSTOMER"))
    {
    	CustomerDaoImp cd=new CustomerDaoImp();
    	customer=cd.getCustomer(username); 	
    	
    }
    
    else if(usertype.equals("ADMIN"))
    {
    	AdminDaoImp ad=new AdminDaoImp();
    	admin=ad.getAdmin(username); 	
    }
%>

<div id="myprofileTable">
      
   <table border="5">
              
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Phone</td>
                <td>Address</td>
            </tr>
            
            <%
            if(usertype.equals("CUSTOMER"))
            {
            %>
               <tr>
                <td><%=customer.getId() %></td>
                <td><%=customer.getName() %></td>
                <td><%=customer.getContact() %></td>
                <td><%=customer.getAddress() %></td>
            </tr>
            <%
            }
            %> 
            
            <%
            if(usertype.equals("ADMIN"))
            {
            %>
               <tr>
                <td><%=admin.getId() %></td>
                <td><%=admin.getName() %></td>
                <td><%=admin.getContact() %></td>
                <td><%=admin.getAddress() %></td>
            </tr>
            <%
            }
            %>                 
             
         
                
    </table>
</div>



<div class="fixed-header">
        <div class="container">
            <nav>
                <%
                 if(usertype!=null && usertype=="CUSTOMER")
                 {
                 %>
                 <a href="Home.jsp">Home</a>
                   <a href="AvailablePizza.jsp">Available Pizza</a>
                   <a href="myCart.jsp">My Cart</a>
                   <a href="myOrder.jsp">My Orders</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
                   
                 <%
                 }  
                
                 else if(usertype!=null && usertype=="ADMIN")
                 {
                 %>
                   <a href="Home.jsp">Home</a>
                   <a href="AvailablePizza.jsp">Available Pizza</a>
                   <a href="addPizza.jsp">Add Pizza</a>
                   <a href="totalCustomers.jsp">Total Customer</a>
                   <a href="totalOrders.jsp">Total Orders</a>
                   <a href="ChangePassword.jsp">Change Password</a>   
                   <a href="SignUpServlet?action=logout">Log out</a>     
                 <%
                 }
                
                 else
                 {
                 %> 
                 <a href="Home.jsp">Home</a>
                    <a href="AvailablePizza.jsp">Available Pizza</a>
                    <a href="signup.jsp" >Sign Up</a>
                    <a href="login.jsp" >Login</a>
                    <a href="ForgotPassword.jsp"> Forgot password</a>
                <%
                 }
                %>
            </nav>
          </div>
        </div> 
      
</body>
</html>