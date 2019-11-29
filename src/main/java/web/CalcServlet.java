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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class CalcServlet extends HttpServlet {
  DataStorage dataStorage;

  public CalcServlet(DataStorage dataStorage) {
    this.dataStorage = dataStorage;
  }

  private Optional<Integer> convert_i(String param) {
    try {
      return Optional.of(Integer.parseInt(param));
    } catch (Exception ignored) {
      return Optional.empty();
    }
  }

  private Optional<String> wrap(String param) {

      return Optional.ofNullable(param);
  }

  private Optional<Integer> divide(int x, int y) {
    if (y==0) return Optional.empty();
    return Optional.of(x/y);
  }

  private Optional<Integer> do_op(String p1, String p2, String op) {
    Optional<Integer> p1o = convert_i(p1);
    Optional<Integer> p2o = convert_i(p2);
    Optional<String> opo = wrap(op);

    return opo.flatMap(o -> p1o.flatMap(i1 -> p2o.flatMap(i2 -> {
      switch (o) {
        case "plus":   return Optional.of(i1 + i2);
        case "minus":  return Optional.of(i1 - i2);
        case "mult":   return Optional.of(i1 * i2);
        case "divide": return divide(i1, i2);
      }
      return Optional.empty();
    })));
  }

  private String calc(String p1, String p2, String op) {
    return do_op(p1, p2, op)
        .map(r -> String.format("%d", r))
        .orElse("Smth went wrong with parameters");
  }

  @Override
  protected void doGet(HttpServletRequest req,
                       HttpServletResponse resp) throws ServletException, IOException {
    Path path= Paths.get("./htmlfiles/calc.html");
    ServletOutputStream os=resp.getOutputStream();
    Files.copy(path,os);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    String name = "empty"; // no user
    if (cookies != null) {
      for (Cookie c: cookies) {
        if (c.getName().equals("%CALC%")) {
          name=c.getValue();
        }
      }
    }
    if(!name.equals("empty")){
      String result=calc(req.getParameter("num1"),req.getParameter("num2"),req.getParameter("op"));
      dataStorage.addToDb(req.getParameter("num1"),req.getParameter("num2"),req.getParameter("op"),result,name);
    }

  }
}
