package controllers;

import database.DBManager;
import entity.Discipline;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TermsModifyController", urlPatterns = "/modify-term")
public class TermsModifyController extends HttpServlet {
    private int idTermG = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int iDTerm = Integer.parseInt(req.getParameter("idModifSem"));
        idTermG = iDTerm;
        List<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("activeDisciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/jsp/terms/term-modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDisciplinesStr = req.getParameter("idSelectDisc");
        int[] idDiscTermModifyInt = Arrays.stream(idDisciplinesStr.split(",")).mapToInt(Integer::parseInt).toArray();
        DBManager.modifyTerm(idTermG, idDiscTermModifyInt);
        resp.sendRedirect("/terms");
    }
}