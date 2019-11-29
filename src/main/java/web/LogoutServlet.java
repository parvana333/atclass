package web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Path path= Paths.get("./htmlfiles/logout.html");
    ServletOutputStream os=resp.getOutputStream();
    Files.copy(path,os);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies(); // NULL
    int id = -1; // no user
    if (cookies != null) {
      for (Cookie c: cookies) {
        if (c.getName().equals("%CALC%")) {
          c.setMaxAge(0);
          resp.addCookie(c);
        }
      }
    }
  }
}
