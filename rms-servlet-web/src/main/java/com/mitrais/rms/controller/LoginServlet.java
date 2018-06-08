package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractController
{

	//original code
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//    {
//        String path = getTemplatePath(req.getServletPath());
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//        requestDispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//    {
//        super.doPost(req, resp);
//
//    }

	//mycode

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            User user = new User();
            user.setUserName(req.getParameter("username"));
            user.setPassword(req.getParameter("userpass"));

            if (UserDaoImpl.getInstance().validate(user)) {
//                HttpSession session = req.getSession(true);
//                session.setAttribute("currentSessionUser",user);
                resp.sendRedirect("users/list");
//                RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
//                rd.forward(req, resp);
            } else {
                resp.sendRedirect("index.jsp");
//                RequestDispatcher rd = req.getRequestDispatcher("index");
//                rd.include(req, resp);
            }


        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
        
    

}
