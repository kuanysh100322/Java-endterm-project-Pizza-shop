<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="pizza.dao.*"%>
<%@ page import ="pizza.pojo.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
            width:80px;
        } 
        
 
</style>
</head>
<body>
<%
    List<Pizza> l=new ArrayList<Pizza>();
    PizzaDaoImp fd=new PizzaDaoImp();
    l=fd.getAllPizza();
    String user=(String)session.getAttribute("usertype");
%>

<div  id="homeTable">
      
            
                       
<%
String usertype=(String)session.getAttribute("usertype");
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>

              <table border="5">
              
            <tr>
                <td>Name</td>
                <td>Category</td>
                <td>Description</td>
                <td>Small Prize</td>
                <td>Medium Price</td>
                <td>Large Price</td>
                <td>Image</td>
                 <% 
                      if(usertype!=null && usertype=="CUSTOMER")
                      {
                 %>
                           <td>Action</td>
                 <%
                       }  
                  %>
                  
                   <% 
                      if(usertype!=null && usertype=="ADMIN")
                      {
                   %>
                           <td colspan="2">Action</td>
                  <%
                       }  
                  %>
            </tr>
            
             
            <% 
                 for(Pizza p:l)
                 {
                	 int id=p.getId();
                	 String name=p.getName();
            %>
              <tr>
                 <td><%=name%></td>
                 <td><%=p.getCategory() %></td>
                 <td><%=p.getDescription() %></td>
                 <td><%=p.getSprice() %></td>
                 <td><%=p.getMprice()%></td>
                 <td><%=p.getLprice()%></td>
                 <td><img src="C:/Users/Vostro.MURADALIMJ/Desktop/PROJECTS/Pizza Project/Images/<%=p.getImage()%>" width="100px" height="100px"></td>
                 
           <% 
           if(usertype!=null && usertype=="ADMIN")
             {
        	   System.out.println("Image path in JSP page : "+p.getImage());
           %>
               <td><a href="PizzaServlet?pizzaId=<%=id %>&pizzaName=<%=name %>&action=Delete"><button>Delete</button></a></td>
               <td><a href="PizzaServlet?pizzaId=<%=id %>&pizzaName=<%=name %>&action=Update"><button>Update</button></a></td>  
               </tr>
           <%
             }  
           %> 
           
            <% 
           if(usertype!=null && usertype=="CUSTOMER")
             {
           %>
               <td><a href="PizzaServlet?pizzaId=<%=id%>&action=viewPizza"><button>View Pizza</button></a></td>  
               </tr>
           <%
             }  
           %> 
           
            
                             
             
            <%
              }
            %>
           
            
        </table>
         
</div>

<div class="fixed-header">
        <div class="container">
            <nav>
                <a href="Home.jsp">Home</a>
               
                <%
                 if(usertype!=null && usertype=="CUSTOMER")
                 {
                 %>
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
                    <a href="signup.jsp" >Sign Up</a>
                    <a href="login.jsp" >Login</a>
                    <a href="ForgotPassword.jsp"> Forget password</a>
                <%
                 }
                %>
            </nav>
          </div>
        </div> 
        
       
     
</body>
</html>