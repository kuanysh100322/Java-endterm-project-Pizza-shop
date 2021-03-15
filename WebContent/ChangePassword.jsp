<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" href="style.css">

<script type="text/javascript" >
function changeValidate()
{
	var flag=false;
	var value=document.forgotForm.type;   /*value is Array here and javascript can understand boz is he is smart */
	for(var i=0;i<value.length ;i++)  
	{
		if(value[i].checked)
		{
			flag=true;
			break;
		}
	}
	
	if(flag==false)
	{
		alert("Please select User type!");
		return false;
	}
}
</script>
</head>
<body>


<div id="loginContent">
       <form name="changeForm" onsubmit="return changeValidate()" action="SignUpServlet" method="post">
        <input type="hidden" name="action" value="changePassword" >
              <table>
              
                     <%
                         String username=(String)session.getAttribute("username"); 
                         String usertype=(String)session.getAttribute("usertype");
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                     %>
                     
                     <tr>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Customer" <%if(usertype.equals("CUSTOMER")){ %>checked<% } %> ><b>Customer</b></td>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Admin" <%if(usertype.equals("ADMIN")){ %>checked<% } %>><b>Admin</b></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" size="40" value=<%= username %> readonly></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Password :</b></td>
                          <td><input type="password" id="password" name="password" size="40" ></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Confirm Password :</b></td>
                          <td><input type="password" id="cpassword" name="cpassword" size="40" ></td>
                          <td><span style="color:red" id="cpasswordError">*</span></td>
                     </tr>
                   
                     <tr>
                         <td><input type="submit" value="Change"></td>
                     </tr>
              </table>
       </form>
         </div>


      <div class="fixed-header">
        <div class="container">
            <nav>
            <a href="Home.jsp">Home</a>
                 <%
                 if(usertype!=null && usertype=="CUSTOMER")
                 {
                 %>
                   <a href="AvailablePizza.jsp">Available Pizza</a>
                   <a href="myCart.jsp">My Cart</a>
                   <a href="myOrder.jsp">My Orders</a>
                   <a href="myProfile.jsp">My Profile</a>
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