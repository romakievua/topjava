package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.MealDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealDAO mealDAO = new MealDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        if ("delete".equals(request.getParameter("action"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            mealDAO.delete(id);
        }

        request.setAttribute("mealWithExceedList", mealDAO.getAll());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);

//        response.sendRedirect("meals.jsp");
    }
}
