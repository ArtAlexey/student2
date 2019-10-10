package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteController", urlPatterns = "/delete-students")
public class StudentDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDelStd = req.getParameter("idDeleteStudent");
        System.out.println(idDelStd);
        String[] idArrayDelStudents = idDelStd.split(",");
        for (String idS : idArrayDelStudents) {
            DBManager.deleteStudents(idS);
        }
        resp.sendRedirect("/students");
    }
}
