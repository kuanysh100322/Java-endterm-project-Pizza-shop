<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Mom & Pop Pizza</title>
<link rel="stylesheet" href="style.css">
<style type="text/css">
  /* #signUpContent input[type="submit"] {
            height: 30px;
            color: #fff;
            font-size: 15px;
            background: red;
            cursor: pointer;
            border-radius: 25px;
            border: none;
            outline: none;
            margin-top: 30%;
            width:150px;
        } */
</style>

<script type="text/javascript">
function signUpValidate()
{
	var flag=false;
	var name=document.getElementById("name").value; 
	var address=document.getElementById("address").value; 
	var phone=document.getElementById("phone").value; 
	var pass=document.getElementById("password").value;   // String
	var cpass=document.getElementById("cpassword").value;
	var passLength=pass.length;
	var value=document.signForm.type;   /*value is Array here and javascript can understand boz is he is smart */
	
	for(var i=0;i<value.length ;i++)  
	{
		if(value[i].checked)
		{
			flag=true;
			break;
		}
	}
	
	if(flag==true)  /* That means user has checked the the user type*/
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
		
		if(address=="")
		{
		 document.getElementById("addressError").innerHTML ="Enter Address.";
		 return false;
		}
	    else
		{
		 document.getElementById("addressError").innerHTML ="";
		}
		
		if(phone=="")
		{
		 document.getElementById("phoneError").innerHTML ="Enter Contact No..";
		 return false;
		}
	    else
		{
		 document.getElementById("phoneError").innerHTML ="";
		}
		
		if(isNaN(phone))
	    {
		   document.getElementById("phoneError").innerHTML=("Please enter numeric value");
	       return false; 
	    }
		 else
			{
			  document.getElementById("phoneError").innerHTML=("");
			}
		
		if(phone.length !=10)
		{
			   document.getElementById("phoneError").innerHTML=("Please enter valid contact No.");
		       return false; 
		    }
			 else
				{
				  document.getElementById("phoneError").innerHTML=("");
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
		
		if(passLength<5 || passLength>8)
		{
			document.getElementById("passwordError").innerHTML ="Password Length should be between 5-8";
			return false;
		}
		
		else
		{
			document.getElementById("passwordError").innerHTML ="";
		}
		
		if(cpass != pass)
	    {
			document.getElementById("confirmPasswordError").innerHTML ="It should be same as password field,";
			return false;
		}
		
		else
		{
			document.getElementById("confirmPasswordError").innerHTML ="";
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
      <div id="signUpContent">
       <form name="signForm" onsubmit="return signUpValidate()" action="SignUpServlet" method="post">
              <input type="hidden" name="action" value="signUp" >
              <table>
                      <%
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                     %>
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
                          <td style="color:white"><b>Address :</b></td>
                          <td style="color:white"><textArea id="address" name="address" cols="30" rows="3" ></textArea></td>
                          <td><span style="color:red" id="addressError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Contact No. :</b></td>
                          <td><input type="text" id="phone" name="phone"  size="40" ></td>
                          <td><span style="color:red" id="phoneError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Password :</b></td>
                          <td><input type="password" id="password" name="password" size="40" ></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td style="color:white"><b>Confirm Password :</b></td>
                          <td><input type="password" id="cpassword" name="cpassword" size="40" ></td>
                          <td><span style="color:red" id="confirmPasswordError">*</span></td>
                     </tr>
                     
                     <tr>
                         <td><input type="submit" value="Register"></td>
                     </tr>
              </table>
       </form>
         </div>
       <div class="fixed-header">
        <div class="container">
            <nav>
            <a href="Home.jsp">Home</a>
                <a href="AvailablePizza.jsp" >Available Pizza</a>
                <a href="login.jsp" >Login</a>
                <a href="ForgotPassword.jsp" >Forget Password </a>
            </nav>
          </div>
        </div> 
        
        
</body>
</html>