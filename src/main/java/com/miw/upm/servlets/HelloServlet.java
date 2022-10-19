package com.miw.upm.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

// La implementación de Servlet que tiene Tomcat 10 es la de Jakarta
/* import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/servlet/helloServlet
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void init() throws ServletException {
        log.info("Se instancia el servlet...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // https://www.roseindia.net/servlets/servlet-read-file.shtml
        String path = "/static/hello.html";
        ServletContext context = getServletContext();
        InputStream inp = context.getResourceAsStream(path);
        resp.setContentType("text/hmtl");
        inp.transferTo(resp.getOutputStream());

        /*
         * PrintWriter out = resp.getWriter();
         * if (inp != null) {
         * InputStreamReader isr = new InputStreamReader(inp);
         * BufferedReader reader = new BufferedReader(isr);
         * String text = "";
         * while ((text = reader.readLine()) != null) {
         * out.println(text);
         * }
         * }
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        log.info("Se destruye el servlet...");
    }
}
