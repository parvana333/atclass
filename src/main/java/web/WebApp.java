package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApp {
  public static void main(String[] args) throws Exception {
   DataStorage d=new DataStorage();
   Auth a=new AuthService();
    Server server = new Server(8082);
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new CalcServlet(d)), "/calc/*");
    handler.addServlet(new ServletHolder(new LoginServlet(a)), "/login/*");
    handler.addServlet(new ServletHolder(new ErrorServlet()),"/error/*");
   handler.addServlet(new ServletHolder(new LogoutServlet()),"/logout/*");
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
