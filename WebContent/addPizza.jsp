<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pizza</title>
<link rel="stylesheet" href="style.css">
<style type="text/css">
    #head
    {
        margin-left:520px;
        margin-top:90px;
        position:fixed;
        background-color: white;
    }
</style>
</head>
<body>

      <div id="addTable" >
       <form name="signForm" action="PizzaServlet" method="post" enctype="multipart/form-data">
              <input type="hidden" name="action" value="addPizza" />
              <table>
                      <%
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                      %>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" size="40" ></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Category :</b></td>
                          <td style="color:white">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" id="category" name="category" value="Veg" ><b>Veg</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          <input type="radio" id="category" name="category" value="Non-Veg"><b>Non-Veg</b></td>
                          <td style="color:white"><span style="color:red" id="categoryError">*</span></td>
                         
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Description :</b></td>
                          <td style="color:white"><textArea id="description" name="description" cols="30" rows="3" ></textArea></td>
                          <td><span style="color:red" id="descriptionError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of small pizza :</b></td>
                          <td><input type="text" id="sprice" name="sprice" size="40" ></td>
                          <td><span style="color:red" id="spriceError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of medium pizza :</b></td>
                          <td><input type="text" id="mprice" name="mprice" size="40" ></td>
                          <td><span style="color:red" id="mpriceError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Price of large pizza :</b></td>
                          <td><input type="text" id="lprice" name="lprice" size="40" ></td>
                          <td><span style="color:red" id="mpriceError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Select the Picture to upload :</b></td>
                          <td><input type="file"  name="image" accept="image/x-png,image/gif,image/jpeg" size="26" required></td>
                     </tr>
                     
                     <tr>
                         <td></td>
                         <td><input type="submit" value="Add Pizza"></td>
                     </tr>
              </table>
       </form>
         </div>

      <div class="fixed-header">
        <div class="container">
            <nav>
            <a href="Home.jsp">Home</a>
                   <a href="AvailablePizza.jsp" >Available Pizza</a>
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