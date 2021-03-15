<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="pizza.dao.*"%>
    <%@ page import ="pizza.pojo.*"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Order</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<%
    String username=(String)session.getAttribute("username");
    List<Order> l=new ArrayList<Order>();
    OrderDaoImp od=new OrderDaoImp();
    l=od.getOrder(username);
%>

<div id="myCartTable">
      
   <table border="5">
              
            <tr>
                <td>Order Id</td>
                <td>Pizza Name</td>
                <td>Pizza Size</td>
                <td>Quantity</td>
                <td>Price</td>
                <td>Date</td>
            </tr>
            
             <% 
                 for(Order o:l)
                 {
                	 int id=o.getOrderId();
                	 String pizzaName=o.getPizzaName();
                	 String quantity=o.getQuantity();
                	 String price=o.getPrice();
                	 String size=o.getSize();
                     String date=o.getDate();
                     
            %>
              <tr>
                 <td><%=id%></td>
                 <td><%=pizzaName %></td>
                 <td><%=size %></td>
                 <td><%=quantity%></td>
                 <td><%=price%></td>
                 <td><%=date %></td>
             </tr>
          
            <%
              }
            %>
                
    </table>
   
</div>

<div style="color:white"  align="center">
    <h2 >  Total Bill : <span><b>$<%= od.totalOrderPrice(username) %></b></span> </h2>
</div>

<div class="fixed-header">
        <div class="container">
            <nav>
                 <a href="Home.jsp">Home</a>
                <a href="AvailablePizza.jsp" >Available Pizza</a>
                <a href="myCart.jsp">My Cart</a>
                <a href="myProfile.jsp">My Profile</a>
                <a href="ChangePassword.jsp">Change Password</a>
                <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 

</body>
</html>