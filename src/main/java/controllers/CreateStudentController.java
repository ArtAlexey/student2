package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "CreateStudent", urlPatterns = "/createStudent")
public class CreateStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/student/create_student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("sSurName");
        String name = req.getParameter("sName");
        String group = req.getParameter("sGroup");
        String date = req.getParameter("sDate");
        DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        java.sql.Date sqlDate = null;
        try {
            Date nDate = sdf.parse(date);
            sqlDate = new java.sql.Date(nDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBManager.createNewStudent(surname, name, group, sqlDate);
        resp.sendRedirect("/students");


    }
}
