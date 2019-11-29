package web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet {
    private final Auth auth;

    public LoginServlet(Auth auth) {
        this.auth = auth;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path= Paths.get("./htmlfiles/login.html");
        ServletOutputStream os=resp.getOutputStream();
        Files.copy(path,os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String name= req.getParameter("name");
     String pasw=req.getParameter("pasw");
     boolean checked=auth.check(name,pasw);
     if(checked){
         Cookie cookie=new Cookie("%CALC%",name);
         cookie.setPath("/");
         resp.addCookie(cookie);
         resp.sendRedirect("/calc/*");
     }
     else{
         resp.sendRedirect("/error/*");
     }
    }
}
