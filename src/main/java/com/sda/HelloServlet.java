package com.sda;

import com.sda.calc.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by RENT on 2017-06-07.
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Calculator calculator = new Calculator();

        PrintWriter writer = resp.getWriter();

        String action = req.getPathInfo();

        Map<String, String[]> parameters = req.getParameterMap();
        String firstValue = parameters.get("first")[0];
        String secondValue = parameters.get("second")[0];
        double result = 0;

        if ("/add".equals(action)) {
            result = calculator.add(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/subtract".equals(action)) {
            result = calculator.subtract(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/multiply".equals(action)) {
            result = calculator.multiply(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        } else if ("/divide".equals(action)) {
            result = calculator.divide(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        }

        writer.println("<h1>Result :" + result + "</h1>");
        addResponse(writer);

//        TestMethod(req, resp);
    }

    private void TestMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        Cookie cookie = new Cookie("cookie-key", "cookie-value");
        cookie.setMaxAge(30);
        resp.addCookie(cookie);

        String requestURI = req.getRequestURI();
        String requestUrl = req.getRequestURI().toString();
        String pathInfo = req.getPathInfo();
        String parameterMap = req.getParameterMap().toString();
        Cookie[] cookieList = req.getCookies();
        String cookies = "";
        if (cookieList != null) {
            cookies = Arrays.asList(req.getCookies()).toString();
        }
        String contextPath = req.getContextPath();
        String method = req.getMethod();

        writer.println("<h1>Hello World</h1>");
        writer.println("<o1>");
        writer.println("<Li> You've requested " + requestURI + "</Li>");
        writer.println("<Li> requestUrl " + requestUrl + "</Li>");
        writer.println("<Li> pathInfo " + pathInfo + "</Li>");
        writer.println("<Li> parameterMap " + parameterMap + "</Li>");
        writer.println("<Li> cookies " + cookies + "</Li>");
        writer.println("<Li> contextPath " + contextPath + "</Li>");
        writer.println("<Li> method " + method + "</Li>");
        writer.println("</o1>");
    }

    private void addResponse(PrintWriter writer) {
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/add\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/subtract\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/multiply\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/calc/divide\">");
        writer.println("<input type=\"number\" name=\"first\">");
        writer.println("<input type=\"number\" name=\"second\">");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
    }

}
