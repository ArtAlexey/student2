package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplinesController", urlPatterns = "/disciplines")
public class DisciplinesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            Cookie cookie = new Cookie("count", "0");
            resp.addCookie(cookie);
        }
        int countNot = 0;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("count")){
                int value = Integer.parseInt(cookie.getValue());
                value++;
                cookie.setValue(value + "");
                resp.addCookie(cookie);
            }else {
                countNot++;
            }
        }
        if(countNot == cookies.length){
            Cookie cookie = new Cookie("count", "1");
            resp.addCookie(cookie);
        }

        List<Discipline> disc = DBManager.getAllActiveDisciplines();
        req.setAttribute("disc", disc);
        req.getRequestDispatcher("/WEB-INF/jsp/discipline.jsp").forward(req, resp);
    }
}
