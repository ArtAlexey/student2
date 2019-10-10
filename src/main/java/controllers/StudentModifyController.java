package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "StudentModifyController", urlPatterns = "/modifyStudent")
public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idModSt = req.getParameter("idModifyStudent");
        Student modStudent = DBManager.getStudentById(idModSt);
        System.out.println(modStudent);
        req.setAttribute("student", modStudent);
        req.getRequestDispatcher("WEB-INF/jsp/student/modify-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mIdMod = req.getParameter("sId");
        String mSurnameMod = req.getParameter("sSurname");
        String mNameMod = req.getParameter("sName");
        String mGroupMod = req.getParameter("sGroup");
        String mDateMod = req.getParameter("sDate");
        DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        java.sql.Date sqlDate = null;
        try {
            Date nDate = sdf.parse(mDateMod);
            sqlDate = new java.sql.Date(nDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBManager.modifyStudent(mIdMod, mSurnameMod, mNameMod, mGroupMod, sqlDate);
        resp.sendRedirect("/students");
    }
}

