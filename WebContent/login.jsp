<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>s
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">

<script type="text/javascript" >
function loginValidate()
{
	var flag=false;
	var value=document.loginForm.type;   /*value is Array here and javascript can understand boz is he is smart */
	var name=document.getElementById("name").value; 
	var pass=document.getElementById("password").value;
	for(var i=0;i<value.length ;i++)  
	{
		if(value[i].checked)
		{
			flag=true;
			break;
		}
	}
	
	if(flag==true)
	{
		if(name=="")
		{
		 document.getElementById("nameError").innerHTML ="Enter Name.";
		 return false;
		}
	    else
		{
		 document.getElementById("nameError").innerHTML ="";
		}
	
	
	
	if(pass=="")
	{
	 document.getElementById("passwordError").innerHTML ="Enter Password..";
	 return false;
	}
    else
	{
	 document.getElementById("passwordError").innerHTML ="";
	}
	
	return true;
	}
	
	else
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
       <form name="loginForm" onsubmit="return loginValidate()" action="SignUpServlet" method="post">
        <input type="hidden" name="action" value="login" >
              <table>
                    
                     <tr>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Customer" ><b>Customer</b></td>
                          <td style="color:white"><input type="radio" id="type" name="type" value="Admin"><b>Admin</b></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Name :</b></td>
                          <td style="color:white"><input type="text" id="name" name="name" size="40" ></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     
                     
                     <tr>
                          <td style="color:white"><b>Password :</b></td>
                          <td><input type="password" id="password" name="password" size="40" ></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                    
                     
                     <tr>
                         <td><input type="submit" value="Login"></td>
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
                <a href="ForgotPassword.jsp" >Forget Password </a>
            </nav>
          </div>
        </div> 
        
   
</body>
</html>