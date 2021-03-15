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
<title>Total Customers</title>
<style type="text/css">
       #totalCustomers
       {
             margin-top:100px ;
             margin-left:440px;
       }
</style>
<link rel="stylesheet" href="style.css">
</head>
<body>
<% 
    List<Customer> li=new ArrayList<>();
   
    CustomerDaoImp od=new CustomerDaoImp();
    li=od.getAllCustomer();
%>

<div id="totalCustomers">
      
   <table border="5">
              
            <tr>
                <td>Customer Id</td>
                <td>Name</td>
                <td>Phone</td>
                <td>Address</td>
            </tr>
            
           <% 
                 for(Customer c:li)
                 {          
            %>
              <tr>
         
                <td><%=c.getId() %></td>
                <td><%=c.getName() %></td>
                <td><%=c.getContact() %></td>
                <td><%=c.getAddress() %></td>
             </tr>
          
            <%
              }
            %>
    </table>
</div>



<div class="fixed-header">
        <div class="container">
            <nav>
                   <a href="Home.jsp">Home</a>
                   <a href="AvailablePizza.jsp" >Available Pizza</a>
                   <a href="addPizza.jsp" >Add Pizza</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="totalOrders.jsp">Total Orders</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 
</body>
</html>