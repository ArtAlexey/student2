package controllers;

import database.DBManager;
import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        Account account = DBManager.getAccount(login, password, role);
        if(account != null){
            req.getSession().setAttribute("isLogin", "1");
            req.getSession().setAttribute("Login", account.getLogin());
            req.getSession().setAttribute("role", account.getRole());

            resp.sendRedirect("/");
        }else{
            req.setAttribute("error", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

        }

    }
}
