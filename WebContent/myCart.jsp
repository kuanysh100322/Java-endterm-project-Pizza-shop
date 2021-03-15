<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="pizza.dao.*"%>
    <%@ page import ="pizza.pojo.*"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link rel="stylesheet" href="style.css">

<style type="text/css">
       button {
            height: 35px;
            color: #fff;
            font-size: 15px;
            background:#800180;
            cursor: pointer;
            border-radius: 25px;
            border: none;
            outline: none;
            margin-top: 1%;
            width:300px;
        } 
        
 
</style>

</head>
<body>

<%
    String username=(String)session.getAttribute("username");
    List<Cart> l=new ArrayList<Cart>();
    CartDaoImp cd=new CartDaoImp();
    PizzaDaoImp pd=new PizzaDaoImp();
    l=cd.getCart(username);
%>

<div id="myCartTable">
      
   <table border="5">
              
            <tr>
                <td>Cart Id</td>
                <td>Pizza Name</td>
                <td>Pizza Image</td>
                <td>Size</td>
                <td>Quantity</td>
                <td>Price</td>
            </tr>
            
             <% 
                 for(Cart c:l)
                 {
                	 int id=c.getCartId();
                	 String name=c.getName();
                	 int pizzaId=c.getPizzaId();
                	 String quantity=c.getQuantity();
                	 String price=c.getPrice();
                	 String size=c.getSize();
                	 
                	 Pizza p=pd.getPizza(pizzaId);
                	 String pizzaName=p.getName();
                	 String pizzaImage=p.getImage();
                     
            %>
              <tr>
                 <td><%=id%></td>
                 <td><%=pizzaName %></td>
                 <td><img src="C:/Users/User/Desktop/PROJECTS/Pizza Project/Images/<%=p.getImage()%>" width="100px" height="100px"></td>
                 <td><%=size %></td>
                 <td><%=quantity%></td>
                 <td><%=price%></td>
             </tr>
          
            <%
              }
            %>
                
    </table>
</div>

<a href="PizzaServlet?action=order"><button id="orderButton"> ORDER </button></a>

<div class="fixed-header">
        <div class="container">
            <nav>
            <a href="Home.jsp">Home</a>
                <a href="AvailablePizza.jsp" >Available Pizza</a>
               <a href="myOrder.jsp">My Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 

</body>
</html>