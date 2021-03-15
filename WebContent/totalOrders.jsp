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
<title>Total Orders</title>
<style type="text/css">
       #myprofileTable
       {
             margin-top:100px ;
             margin-left:250px;
       }
</style>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String username=(String)session.getAttribute("username");
    List<Order> li=new ArrayList<>();
    Order order=new Order();
    OrderDaoImp od=new OrderDaoImp();
    li=od.getAllOrder();
%>

<div id="myprofileTable">
      
   <table border="5">
              
            <tr>
                <td>Order Id</td>
                <td>Name</td>
                <td>Phone</td>
                <td>Address</td>
                <td>Pizza Name</td>
                <td>Pizza Size</td>
                <td>Quantity</td>
                <td>Price</td>
                <td>Ordered Date</td>
            </tr>
            
           <% 
                 for(Order o:li)
                 {
                	 Customer customer=new Customer();
                	 customer=new CustomerDaoImp().getCustomer(o.getUsername());
                     
            %>
              <tr>
                 <td><%=o.getOrderId() %></td>
                <td><%=o.getUsername() %></td>
                <td><%=customer.getContact() %></td>
                <td><%=customer.getAddress() %></td>
                <td><%=o.getPizzaName() %></td>
                <td><%=o.getSize() %></td>
                <td><%=o.getQuantity() %></td>
                <td><%=o.getPrice() %></td>
                <td><%=o.getDate() %></td>
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
                   <a href="totalCustomers.jsp">Total Customer</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 
</body>
</html>