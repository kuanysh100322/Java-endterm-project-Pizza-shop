package pizza.servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import pizza.dao.CartDaoImp;
import pizza.dao.OrderDaoImp;
import pizza.dao.PizzaDaoImp;
import pizza.pojo.Cart;
import pizza.pojo.Order;
import pizza.pojo.Pizza;

/**
 * Servlet implementation class PizzaServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/PizzaServlet")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "Images";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		RequestDispatcher rd;
		if(action.equals("Delete"))
		{	
			String name=request.getParameter("pizzaName");
			int id=Integer.parseInt(request.getParameter("pizzaId")); 
			PizzaDaoImp pd=new PizzaDaoImp();
			Pizza p=pd.getPizza(id);
			String image=p.getImage();
			boolean flag=pd.deletePizza(id);
			
			if(flag==true)
	        {
				File f=new File("C:\\Users\\User\\Desktop\\Pizza Project\\Images\\"+image);
				if(f.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
		        else
		        { 
		            System.out.println("Failed to delete the file"); 
		        } 
	        	request.setAttribute("status","<span id='Success'><b>"+name+"</b> deleted successfuly.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
	        
	        else
	        {
	        	request.setAttribute("status","<span id='Fail'> Failed to delete <b>"+name+"</b>.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
			
		}
		
		else if(action.equals("Update"))
		{
			int id=Integer.parseInt(request.getParameter("pizzaId")); 
			PizzaDaoImp pd=new PizzaDaoImp();
			Pizza pizza=pd.getPizza(id);
			request.setAttribute("Pizza",pizza);
			rd=request.getRequestDispatcher("updatePizza.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("viewPizza"))
		{
			int id=Integer.parseInt(request.getParameter("pizzaId")); 
			PizzaDaoImp pd=new PizzaDaoImp();
			Pizza pizza=pd.getPizza(id);
			request.setAttribute("Pizza",pizza);
			rd=request.getRequestDispatcher("addToCart.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("order"))
		{
			LocalDate date=LocalDate.now();
			String orderedDate=String.valueOf(date);
			String username=(String)session.getAttribute("username");
			CartDaoImp cd=new CartDaoImp();
			Order order=new Order();
			PizzaDaoImp pd=new PizzaDaoImp();
			OrderDaoImp od=new OrderDaoImp();
			List<Cart> cart=cd.getCart(username);
			String totalBill=null;
		    for(Cart c:cart)
		    {
			    int pizzaId=c.getPizzaId();
			    Pizza pizza=pd.getPizza(pizzaId);
			    String pizzaName=pizza.getName();
		  
			    order.setUsername(username);
		    	order.setPizzaName(pizzaName);
		    	order.setSize(c.getSize());
		    	order.setQuantity(c.getQuantity());
		    	order.setPrice(c.getPrice());
		    	order.setDate(orderedDate);
		    	od.addOrder(order);
		    		
		    }
		        cd.deleteCart(username);
		        totalBill=od.totalOrderPrice(username);
	        	request.setAttribute("status","<span id='Success'>Selected Pizza ordered successfuly. Your Total Bill is $"+totalBill+"</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	       
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        RequestDispatcher rd;
		String action=request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
		
		if(action.equals("addPizza"))
		{
			String name=request.getParameter("name");
			String category=request.getParameter("category");
			String description=request.getParameter("description");
			String sprice=request.getParameter("sprice");
			String mprice=request.getParameter("mprice");
			String lprice=request.getParameter("lprice");
			Part part =request.getPart("image");
			 String fileName = extractFileName(part);  
			    System.out.println("Extracted File Name : "+fileName);
			    
			    String imageFileName=fileName.substring(fileName.lastIndexOf("\\")+1);
			    System.out.println(imageFileName);
			    
			    String applicationPath = getServletContext().getRealPath("");
			    System.out.println("Application Path : "+applicationPath);
			    
			    StringBuffer sb=new StringBuffer(applicationPath);
				sb=sb.delete(applicationPath.indexOf("\\.meta"),applicationPath.lastIndexOf("\\Pizza"));
			    System.out.println(sb);
			  	   
		  	  
			  	String editedApplicationPath=new String(sb);
			    
			    
			    String uploadPath=editedApplicationPath+UPLOAD_DIR;
			    System.out.println("Upload Path : "+uploadPath);
			    
			    System.out.println("Final Image Path ibn Images Folder : "+uploadPath+File.separator+imageFileName);
			    
			    File fileUploadDirectory = new File(uploadPath);
		        if (!fileUploadDirectory.exists()) {
		            fileUploadDirectory.mkdirs();
		        }
		        
		        part.write(uploadPath + File.separator+imageFileName+ File.separator);
	      
	        Pizza pizza=new Pizza(name, category, description, sprice, mprice, lprice, imageFileName);
	        PizzaDaoImp pd=new PizzaDaoImp();
	        boolean flag=pd.addPizza(pizza);
	        
	        if(flag==true)
	        {
	        	request.setAttribute("status","<span id='Success'><b>"+name+"</b> added successfuly.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
	        
	        else
	        {
	        	request.setAttribute("status","<span id='Fail'> Failed to add <b>"+name+"</b>.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
	        
	        
	        
		}
		
		else if (action.equals("updatePizza"))
		{
	
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println("id : "+id);
			String name=request.getParameter("name");
			String category=request.getParameter("category");
			String description=request.getParameter("description");
			String sprice=request.getParameter("sprice");
			String mprice=request.getParameter("mprice");
			String lprice=request.getParameter("lprice");
			Part part=request.getPart("image");
			
			PizzaDaoImp pd=new PizzaDaoImp();
			Pizza pizza=pd.getPizza(id);
			String imageName=pizza.getImage();
	
			File f=new File("C:\\Users\\User\\Desktop\\Pizza Project\\Images\\"+imageName);
			if(f.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
			
			String fileName = extractFileName(part);  
		    System.out.println("Extracted File Name : "+fileName);
		    
		    String imageFileName=fileName.substring(fileName.lastIndexOf("\\")+1);
		    System.out.println(imageFileName);
		    
		    String applicationPath = getServletContext().getRealPath("");
		    System.out.println("Application Path : "+applicationPath);
		    
		    StringBuffer sb=new StringBuffer(applicationPath);
			sb=sb.delete(applicationPath.indexOf("\\.meta"),applicationPath.lastIndexOf("\\Pizza"));
		    System.out.println(sb);
		  	   
	  	  
		  	String editedApplicationPath=new String(sb);
		    
		    
		    String uploadPath=editedApplicationPath+UPLOAD_DIR;
		    System.out.println("Upload Path : "+uploadPath);
		    
		    System.out.println("Final Image Path ibn Images Folder : "+uploadPath+File.separator+imageFileName);
		    
		    File fileUploadDirectory = new File(uploadPath);
	        if (!fileUploadDirectory.exists()) {
	            fileUploadDirectory.mkdirs();
	        }
	        
	        part.write(uploadPath + File.separator+imageFileName+ File.separator);
	       
	        Pizza p=new Pizza(name, category, description, sprice, mprice, lprice, imageFileName);
	        p.setId(id);
	        PizzaDaoImp pd1=new PizzaDaoImp();
	        boolean flag=pd1.updatePizza(p);
	        
	        if(flag==true)
	        {
	        	request.setAttribute("status","<span id='Success'><b>"+name+"</b> Updated successfuly.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
	        
	        else
	        {
	        	request.setAttribute("status","<span id='Fail'> Failed to Update <b>"+name+"</b>.</span>");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
	        }
	        
			
		}
		
		else if(action.equals("addToCart"))
		{
			
			int pizzaId=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String category=request.getParameter("category");
			String description=request.getParameter("description");
			String sprice=request.getParameter("sprice");
			String mprice=request.getParameter("mprice");
			String lprice=request.getParameter("lprice");
			String size=request.getParameter("size");
			String quantity=request.getParameter("quantity");
			String username=(String)session.getAttribute("username");
			String price=null;
			String fprice=null;
			if(size.equals("small"))
			{
				price=sprice;
			}
			
			else if(size.equals("medium"))
			{
				price=mprice;
			}
			
			else if(size.equals("large"))
			{
				price=lprice;
			}
			
			CartDaoImp cd=new CartDaoImp();
			
			boolean check=cd.alreadyAvailableInCart(pizzaId,username,size);
			
			if(check==false)
			{
				int finalPrice=Integer.parseInt(quantity)*Integer.parseInt(price);
				fprice=String.valueOf(finalPrice);
				Cart cart=new Cart(pizzaId,username,quantity,size,fprice);
				
				boolean flag=cd.addToCart(cart);
				
				if(flag==true)
		        {
		        	request.setAttribute("status","<span id='Success'><b>"+name+"</b> added to cart successfuly.</span>");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
		        }
		        
		        else
		        {
		        	request.setAttribute("status","<span id='Fail'> Failed to add <b>"+name+"</b> to the cart.</span>");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
		        }
			}
			
			else
			{
				String quan=cd.getPreviousQuantityFromCart(pizzaId, username,size);
			    int finalQuantity=Integer.parseInt(quantity)+Integer.parseInt(quan);
			    String fquan=String.valueOf(finalQuantity);
				int finalPrice=finalQuantity*Integer.parseInt(price);
				fprice=String.valueOf(finalPrice);
				
				boolean flag=cd.updateCart(pizzaId, username, fquan, fprice,size);
				
				if(flag==true)
		        {
		        	request.setAttribute("status","<span id='Success'><b>"+name+"</b> added to cart successfuly.</span>");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
		        }
		        
		        else
		        {
		        	request.setAttribute("status","<span id='Fail'> Failed to add <b>"+name+"</b> to the cart.</span>");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
		        }
				
			}	
			
		}
        
      

    }
    // file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"

    private String extractFileName(Part part)
    {   //This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
		
		
		        
	
		
}


