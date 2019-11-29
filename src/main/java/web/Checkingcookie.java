package web;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public  class Checkingcookie{
    static   HttpServletRequest  req_http;
    public static boolean check(ServletRequest req){
        if (req instanceof HttpServletRequest) {
            req_http = (HttpServletRequest) req;
        }
        Cookie[] cookies = req_http.getCookies();
        String name = "empty"; // no user
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("%CALC%")) {
                    name=c.getValue();
                }
            }
        }
        if(!name.equals("empty")) return true;
        else return false;
    }
}
