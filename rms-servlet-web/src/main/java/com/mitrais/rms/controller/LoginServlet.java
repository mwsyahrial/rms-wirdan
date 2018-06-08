package com.mitrais.rms.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends AbstractController
{

	//original code
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
        
    }

	//mycode
    
  

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//    {
//    	
//    	
//    	String n =req.getParameter("username");
//    	String p =req.getParameter("userpass");
//    	User user = new User(req.getParameter("username"), req.getParameter("userpass"));
//    	if (UserDaoImpl.validate(user)) {
//    	    RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
//            rd.forward(req,resp);  
//        }  
//        else{  
//            out.print("Sorry username or password error");  
//            RequestDispatcher rd=req.getRequestDispatcher("index.jsp");  
//            rd.include(req,resp);  
//        }  
//              
//        out.close();  
//        }  
//    	
//    	
        
    

}
