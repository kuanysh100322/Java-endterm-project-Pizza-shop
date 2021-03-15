<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="pizza.dao.*"%>
<%@ page import ="pizza.pojo.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<style type="text/css">
         #homeImage
        {
           margin-top: 110px;
           position:fixed;
        } 
        
        #head
        {
           margin-top: 100px;
           margin-left: 770px;
           background-color: #800180;
           color:white;
           position:fixed;
        }
        
        #line1
        {
           margin-top: 150px;
           margin-left: 770px;
           color:white;
           position:fixed;
        }
        
        #line2
        {
           margin-top: 340px;
           margin-left: 780px;
            background-color: #800180;
           color:white;
           position:fixed;
        }
        
        #line3
        {
           margin-top: 390px;
           margin-left: 770px;
           color:white;
           position:fixed;
        }
        
         #line4
        {
           margin-top: 450px;
           margin-left: 770px;
           color:#800180;
           position:fixed;
           background-color: white;
        }
        
      
       
</style>
<link rel="stylesheet" href="style.css">
</head>
<body >
<%
String usertype=(String)session.getAttribute("usertype");

%>



<div id="homeImage">
     <img src="C:\Users\User\Downloads\margarita.jpg" width="700px" height="470px">
</div>

<h1 id="head">-----------KAZ PIZZA SHOP--------</h1>
<p id="line1">No matter what the situation, pizza always helps. Especially a pizza that gives you the freedom to choose your topping - from garlic, crisp chips, onion, grilled mushroom, golden corn, black olives, fresh tomato, red paprika, jalapeno, paneer and extra cheese to non-veg toppings such as pepper barbeque chicken, kari chicken, grilled chicken rasher, chicken sausage or chicken thigh- the options are almost endless, anything and everything you can think of that too on top of the crust of your choice - New hand-tossed crust, wheat thin crust, cheese burst crust, classic hand-tossed crust or a fresh pan pizza. We are better than Dodo pizza.</p>
<h2 id="line2">----------The Promise Of 30-Minute Delivery--------</h2>
<p id="line3">The icing on the cake or more aptly the extra cheese on your already fabulous pizza is that Our team takes only half an hour for our pizza delivery service.</p>
<h4 id="line4">There is something for everyone here. The vegetarians, non-vegetarians, the sides lovers and also the ones who love to have something sweet by the time they reach the last bite of the last slice of pizza slice.</h4>
<% 
        String status=(String)request.getAttribute("status");
        if(status!=null)
        {
           out.println(status);	
        }
%>


<div class="fixed-header">
        <div class="container">
            <nav>
                
                 <%
                 if(usertype!=null && usertype=="CUSTOMER")
                 {
                 %>
                   <a href="AvailablePizza.jsp">Available Pizza</a>
                   <a href="myCart.jsp">My Cart</a>
                   <a href="myOrder.jsp">My Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
                     <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
                 <%
                 }  
                
                 else if(usertype!=null && usertype=="ADMIN")
                 {
                 %>
                   <a href="AvailablePizza.jsp">Available Pizza</a>
                   <a href="addPizza.jsp">Add Pizza</a>
                   <a href="totalCustomers.jsp">Total Customer</a>
                   <a href="totalOrders.jsp">Total Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="ChangePassword.jsp">Change Password</a>  
                   <a href="SignUpServlet?action=logout">Log out</a>      
                 <%
                 }
                
                 else
                 {
                 %> 
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