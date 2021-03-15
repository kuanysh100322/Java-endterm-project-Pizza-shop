<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="style.css">

<script type="text/javascript" >
function forgotValidate()
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
<%
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                     %>

<div id="loginContent">
       <form name="forgotForm" onsubmit="return forgotValidate()" action="SignUpServlet" method="post">
        <input type="hidden" name="action" value="forgotPassword" >
              <table>
              
                     
                     
                     <tr>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Customer" ><b>Customer</b></td>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Admin"><b>Admin</b></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" size="40" required ></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Contact Number :</b></td>
                          <td style="color:white"><input type="text" id="contact" name="contact" size="40" required ></td>
                          <td><span style="color:red" id="contactError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Password :</b></td>
                          <td><input type="password" id="cpassword" name="password" size="40" required></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Confirm Password :</b></td>
                          <td><input type="password" id="cpassword" name="cpassword" size="40" required ></td>
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
                <a href="AvailablePizza.jsp" >Available Pizza</a>
                <a href="signup.jsp" >Sign Up</a>
                <a href="login.jsp" >Login</a>
            </nav>
          </div>
        </div> 
        


</body>
</html>