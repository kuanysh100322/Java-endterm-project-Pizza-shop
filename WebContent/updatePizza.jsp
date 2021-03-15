<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="pizza.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Pizza</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

      <div id="addTable">
       <form  action="PizzaServlet" method="post" enctype="multipart/form-data">
              <input type="hidden" name="action" value="updatePizza" >
              <table>
                      <%
                         String cat=null;
                         Pizza pizza=(Pizza)request.getAttribute("Pizza");
                         if(pizza!=null)
                         {
                        	  cat=pizza.getCategory();
                         }
                       
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                      %>
                      
                      <tr>
                          <td style="color:white"><b>ID :</b></td>
                          <td style="color:white"><input type="text" id="id" name="id" value=<%=pizza.getId() %> size="40" readonly></td>
                          <td><span style="color:red" id="idError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" value=<%=pizza.getName() %> size="40" required></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Category :</b></td>
                          <td style="color:white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" id="category" name="category" value="Veg" <% if(cat.equals("Veg")){ %>checked<% } %> ><b>Veg</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          <input type="radio" id="category" name="category" value="Non-Veg" <% if(cat.equals("Non-Veg")){ %>checked<% } %>><b>Non-Veg</b></td>
                          <td style="color:white"><span style="color:red" id="categoryError">*</span></td>
                         
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Description :</b></td>
                          <td style="color:white"><textArea   id="description" name="description"  cols="30" rows="3"  required><%=pizza.getDescription() %></textArea></td>
                          <td><span style="color:red" id="descriptionError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of small pizza :</b></td>
                          <td><input type="text" id="sprice" name="sprice" value=<%=pizza.getSprice()%> size="40" required></td>
                          <td><span style="color:red" id="spriceError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of medium pizza :</b></td>
                          <td><input type="text" id="mprice" name="mprice" value=<%=pizza.getMprice() %> size="40" required></td>
                          <td><span style="color:red" id="mpriceError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of large pizza :</b></td>
                          <td><input type="text" id="lprice" name="lprice" size="40" value=<%=pizza.getLprice() %> required></td>
                          <td><span style="color:red" id="mpriceError">*</span></td>
                     </tr>
                     
                     <tr>     
                          <td style="color:white"><b>Select the Picture to upload :</b></td>
                          <td><input type="file"  name="image" size="26" required></td>
                     </tr>
                     
                     <tr>
                         <td></td>
                         <td><input type="submit" value="Update Pizza"></td>
                     </tr>
              </table>
       </form>
         </div>

      <div class="fixed-header">
        <div class="container">
            <nav>
                 <a href="Home.jsp">Home</a>
                <a href="addPizza.jsp" >Add Pizza</a>
                <a href="totalCustomers.jsp">Total Customer</a>
                   <a href="totalOrders.jsp">Total Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
                   <a href="ChangePassword.jsp">Change Password</a>
                   <a href="SignUpServlet?action=logout">Log out</a>
            </nav>
          </div>
        </div> 
       
</body>
</html>