package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/users/*")
public class UserServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getTemplatePath(req.getServletPath() + req.getPathInfo());
        String action = req.getParameter("action");
        try {
            if ("/list".equalsIgnoreCase(req.getPathInfo())) {
                UserDao userDao = UserDaoImpl.getInstance();
                List<User> users = userDao.findAll();
                req.setAttribute("users", users);
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//                requestDispatcher.forward(req, resp);
            }
            if ("/form".equalsIgnoreCase(req.getPathInfo())) {

//                RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//                requestDispatcher.forward(req, resp);
            }
            if ("/update".equalsIgnoreCase(req.getPathInfo())) {

//                RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//                requestDispatcher.forward(req, resp);
            }
             if (action.equalsIgnoreCase("delete")) {
                User user = new User();
                user.setId(Long.parseLong(req.getParameter("id")));
                UserDaoImpl.getInstance().delete(user);
                 UserDao userDao = UserDaoImpl.getInstance();
                 List<User> users = userDao.findAll();
                 req.setAttribute("users", users);
//                 RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//                 requestDispatcher.forward(req, resp);


            }


             if (action.equalsIgnoreCase("update")) {
                String auser = req.getParameter("username");
                Optional<User> user = UserDaoImpl.getInstance().findByUserName(auser);
                req.setAttribute("user", user);
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/update");
//                requestDispatcher.forward(req, resp);

            }


        } catch (Exception ex)

        {
            ex.printStackTrace();
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if ("/form".equalsIgnoreCase(req.getPathInfo())) {
            try {
                User user = new User();
                user.setUserName(req.getParameter("username"));
                user.setPassword(req.getParameter("userpass"));

                if (user.getUserName() != "" && user.getPassword() != "") {

                    UserDaoImpl.getInstance().save(user);
//                HttpSession session = req.getSession(true);
//                session.setAttribute("currentSessionUser",user);
                    resp.sendRedirect("list");
//                RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
//                rd.forward(req, resp);
                } else {
                    resp.sendRedirect("form");
//                    RequestDispatcher rd = req.getRequestDispatcher("index");
//                    rd.include(req, resp);
                }
            }

//            else {
//                resp.sendRedirect("form");
//            }

            catch (Exception ex)

            {
                ex.printStackTrace();
            }


        }

        if ("/update".equalsIgnoreCase(req.getPathInfo())) {
            try {
                User user = new User();
                user.setId(Long.parseLong(req.getParameter("id")));
                user.setUserName(req.getParameter("username"));
                user.setPassword(req.getParameter("userpass"));

                if (user.getId() != 0 && user.getUserName() != "" && user.getPassword() != "") {

                    UserDaoImpl.getInstance().update(user);
//                HttpSession session = req.getSession(true);
//                session.setAttribute("currentSessionUser",user);
                    resp.sendRedirect("list");
//                RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
//                rd.forward(req, resp);
                } else {
                    resp.sendRedirect("update");
//                    RequestDispatcher rd = req.getRequestDispatcher("index");
//                    rd.include(req, resp);
                }
            }

//            else {
//                resp.sendRedirect("form");
//            }

            catch (Exception ex)

            {
                ex.printStackTrace();
            }


        }
    }
}



