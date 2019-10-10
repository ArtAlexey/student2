package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TermCreateController", urlPatterns = "/create-term")
public class TermCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("allActiveDisc", disciplines);
        req.getRequestDispatcher("WEB-INF/jsp/terms/term-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newTerm = req.getParameter("nameTerm");
        String newDuration = req.getParameter("newDuration");
        String idDiscTremStr = req.getParameter("idTermDisc");
        int[] idDiscTermInt = Arrays.stream(idDiscTremStr.split(",")).mapToInt(Integer::parseInt).toArray();
        DBManager.createNewTerm(newTerm, newDuration, idDiscTermInt);
        resp.sendRedirect("/terms");
    }
}

