package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletsUtils.LOGIN;
import static utils.ServletsUtils.PASSWORD;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        for(Cookie c : req.getCookies()) {
            if(c.getName().equals(LOGIN) || c.getName().equals(PASSWORD)) { c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
