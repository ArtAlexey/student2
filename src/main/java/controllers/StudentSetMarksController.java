package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentSetMarksController", urlPatterns = "/setMarks")
public class StudentSetMarksController extends HttpServlet {
    int idStudent = 0;
    int idTerm = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idStudent = Integer.parseInt(req.getParameter("idSetStudent"));
        idTerm = Integer.parseInt(req.getParameter("idSetTerm"));
        List<Discipline> disciplinesBySelectTerm = DBManager.getDisciplinesInSemestr(idTerm + "");
        req.setAttribute("disciplineByTerm", disciplinesBySelectTerm);
        req.getRequestDispatcher("WEB-INF/jsp/student/student-set-marks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String markAndIdDiscStr = req.getParameter("markAndIdDisc");
        String[] arrayMarksAndIdDisc = markAndIdDiscStr.split(",");
        DBManager.deleteMarksStudent(idStudent, idTerm);
        for (int i = 0; i < arrayMarksAndIdDisc.length-2; i = i + 2) {
            int mark1 = Integer.parseInt(arrayMarksAndIdDisc[i]);
            int idDiscipline1 = Integer.parseInt(arrayMarksAndIdDisc[i + 1]);
            DBManager.setMarks(idStudent, idTerm, idDiscipline1, mark1);
        }
        resp.sendRedirect("/student-progress");
        //req.getRequestDispatcher("WEB-INF/jsp/student/student-progress.jsp").forward(req,resp);
    }
}
