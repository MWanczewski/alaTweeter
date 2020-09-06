package controllers;


import services.TweetManagementService;
import services.impl.TweetManagementServiceImpl;
import utils.ServletsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletsUtils.TWEET_MESSAGE_PARAM;

@WebServlet(name = "AddTweetServlet", value = "/addMessage")
public class AddTweetServlet extends HttpServlet {
    private TweetManagementService service;

    @Override
    public void init() throws ServletException {
       service = new TweetManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLoginFromSession = ServletsUtils.getUserLoginFromSession(req);
        String message = req.getParameter(TWEET_MESSAGE_PARAM);
        if(message == null || message.isEmpty()) {
            req.getRequestDispatcher("messages").forward(req, resp);
            return;
        }
        service.addTweet(userLoginFromSession, message);
        req.getRequestDispatcher("messages").forward(req, resp);
    }
}
