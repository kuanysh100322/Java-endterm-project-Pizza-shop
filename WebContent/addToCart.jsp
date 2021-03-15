<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import ="pizza.pojo.*"%>
<!DOCTYPE>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pizza</title>
<link rel="stylesheet" href="style.css">

<style type="text/css">
    #imageP
    {
       margin-top:70px ;
       margin-left:500px;
    }
    
     #cartTable
        {
              margin-left:350px;
        }
                
</style>

</head>
<body>

<%   Pizza pizza=(Pizza)request.getAttribute("Pizza"); %>
       <img src="C:/Users/Vostro.MURADALIMJ/Desktop/PROJECTS/Pizza Project/Images/<%=pizza.getImage()%>" width="200px" height="200px" id="imageP">
       
      <div id="cartTable" >
      
       <form name="signForm" action="PizzaServlet" method="post" >
              <input type="hidden" name="action" value="addToCart" />
              
              <table>
                      <% 
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                      %>
                      
                     <tr>
                          <td style="color:white"><b>Pizza Id :</b></td>
                          <td style="color:white"><input type="text" id="id" name="id" value=<%=pizza.getId() %> size="40" readonly></td>
        
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" value=<%=pizza.getName() %> size="40" readonly ></td>
                          
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Category :</b></td>
                          <td style="color:white"><input type="text" id="category" name="category" value=<%=pizza.getCategory() %> size="40" readonly></td>
                          
                         
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Description :</b></td>
                          <td style="color:white"><textArea id="description" name="description"  cols="30" rows="3" readonly><%=pizza.getDescription() %></textArea></td>
                         
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of small pizza :</b></td>
                          <td><input type="text" id="sprice" name="sprice" size="40" value=<%=pizza.getSprice() %> readonly></td>
                       
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of medium pizza :</b></td>
                          <td><input type="text" id="mprice" name="mprice" size="40" value=<%=pizza.getMprice() %> readonly></td>
                          
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of large pizza :</b></td>
                          <td><input type="text" id="lprice" name="lprice" size="40" value=<%=pizza.getLprice() %> readonly></td>
                         
                     </tr>
                     
                      <tr>
                          <td style="color:white"><b>Select Pizza Size :</b></td>
                          <td>
                                 <select id="size" name="size" >
                                         <option value="small">Small</option>
                                         <option value="medium">Medium</option>
                                         <option value="large">Large</option>
                                 </select>

                          </td>
                     
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Quantity :</b></td>
                          <td><input type="text" id="quantity" name="quantity" size="40" required></td>
                         
                     </tr>
                     
                     <tr>
                         <td></td>
                         <td><input type="submit" value="Add To Cart"></td>
                     </tr>
              </table>
       </form>
         </div>

      <div class="fixed-header">
        <div class="container">
            <nav>
            <a href="Home.jsp">Home</a>
                <a href="AvailablePizza.jsp" >Available Pizza</a>
                 <a href="myCart.jsp" >My Cart</a>
               <a href="myOrder.jsp">My Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 
        
      
</body>
</html>