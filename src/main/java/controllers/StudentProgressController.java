package controllers;

import database.DBManager;
import entity.Mark;
import entity.Semestr;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    String idStudent = "";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //idStudProgress = Integer.parseInt(req.getParameter("idStudentProgress"));
        String idS2 = req.getParameter("idStudent");
        String idS1 = req.getParameter("idStudentProgress");

        if (idS1 == null && idS2 == null) {
            System.out.println("Mistake");  /*Это нужно поместить в лог!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        } else if (idS1 != null) {
            idStudent = idS1;
        } else {
            idStudent = idS2;
        }
        Student student = DBManager.getStudentById(idStudent);
        List<Semestr> semestrs = DBManager.getAllActiveSemestrs();
        req.setAttribute("terms", semestrs);
        String setIdTermStr = req.getParameter("getTermId");
        if (setIdTermStr == null) {
            setIdTermStr = semestrs.get(0).getId() + "";
        }
        int setIdTerm = Integer.parseInt(setIdTermStr);
        Semestr selectedSemestr = DBManager.getTermsById(setIdTerm);
        List<Mark> marks = DBManager.getMarkByStudentSemestr(idStudent, setIdTerm);
        String avgMarkGeneral = DBManager.getAVGmarkStudent(idStudent);
        String avgMarkOfTerm = DBManager.getAVGmarkOfTerm(idStudent, setIdTerm);
        req.setAttribute("marks", marks);
        req.setAttribute("selectedSemestr", selectedSemestr);
        req.setAttribute("student", student);
        req.setAttribute("avgMarksAll", avgMarkGeneral);
        req.setAttribute("avgMarkTerm", avgMarkOfTerm);
        req.getRequestDispatcher("WEB-INF/jsp/student/student-progress.jsp").forward(req,resp);
    }
}
