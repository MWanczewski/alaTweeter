package controllers;

import services.UserManagementService;
import services.impl.UserManagementServiceImpl;
import utils.ServletsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletsUtils.USER_LOGIN_TO_FOLLOW;

@WebServlet(name = "FollowServlet", value = "/follow")
public class FollowServlet extends HttpServlet {
    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLoginFromSession = ServletsUtils.getUserLoginFromSession(req);
        String userLoginToFollow = req.getParameter(USER_LOGIN_TO_FOLLOW);
        service.follow(userLoginFromSession, userLoginToFollow);
        req.getRequestDispatcher("users").forward(req, resp);

    }


}
