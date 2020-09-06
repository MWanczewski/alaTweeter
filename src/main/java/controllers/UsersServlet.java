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

import static utils.ServletsUtils.FOLLOWED_USERS;
import static utils.ServletsUtils.NOT_FOLLOWED_USERS;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
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
        req.setAttribute(NOT_FOLLOWED_USERS, service.getNotFollowedUsers(userLoginFromSession));
        req.setAttribute(FOLLOWED_USERS, service.getFollowedUsers(userLoginFromSession));
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

}
