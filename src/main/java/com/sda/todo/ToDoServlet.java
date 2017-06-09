package com.sda.todo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public class ToDoServlet extends HttpServlet {

    private ToDoDao toDoDao;
    private ToDoView toDoView;
    private ToDoChain toDoChain;

    @Override
    public void init() throws ServletException {
        toDoDao = new ToDoDaoMock();
        toDoView = new ToDoViewHtml();
        toDoChain = new ToDoChain(toDoView, toDoDao);
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.println(toDoChain.invoke(req.getPathInfo()));
//        List<ToDoModel> allToDOs = toDoDao.getAllToDOs();
//        String toDosView = toDoView.show(allToDOs);
//        writer.println("<ul>");
//
//        for(ToDoModel model : allToDOs) {
//            writer.println("<li>");
//            writer.println("<h3>" + model.getDate().toString() + "</h3>");
//            writer.println("<h1>" + model.getName() + "</h1>");
//            writer.println("<p>" + model.getDescription() + "</p>");
//            writer.println("<p>");
//            for (int i = 0; i < model.getPriority(); i ++) {
//                writer.print("x");
//            }
//            writer.println("</p>");
//            writer.println("</li>");
//
//        } writer.print("<ul>"); writer.println("<ul>");
//
//        for(ToDoModel model : allToDOs) {
//            writer.println("<li>");
//            writer.println("<h3>" + model.getDate().toString() + "</h3>");
//            writer.println("<h1>" + model.getName() + "</h1>");
//            writer.println("<p>" + model.getDescription() + "</p>");
//            writer.println("<p>");
//            for (int i = 0; i < model.getPriority(); i ++) {
//                writer.print("x");
//            }
//            writer.println("</p>");
//            writer.println("</li>");
//
//        } writer.print("<ul>");
//    }
//        allToDOs.stream()
//                .map(e -> Arrays.asList(e.split(" ")))
//                .flatMap(e -> e.stream())

    }
}
