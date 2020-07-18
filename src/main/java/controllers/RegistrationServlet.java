package controllers;

import controllers.validation.ValidationError;
import model.AppUser;
import services.UserManagementService;
import services.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utils.ServletsUtils.*;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ValidationError> errors = new ArrayList<>();
        String login = req.getParameter(LOGIN);
        String email = req.getParameter(EMAIL);

        if(!service.isUserLoginAvailable(login)) {
            errors.add(new ValidationError(ERROR_LOGIN_HEADER, ERROR_LOGIN_REG_MESSAGE));
        }

        if(!service.isUserEmailAvailable(email)) {
            errors.add(new ValidationError(ERROR_EMAIL_HEADER, ERROR_EMAIL_REG_MESSAGE));
        }

        if(errors.isEmpty()) {
            AppUser user = AppUser.UserBuilder
                    .getBuilder()
                    .login(login)
                    .email(email)
                    .name(req.getParameter(NAME))
                    .lastName(req.getParameter(LAST_NAME))
                    .password(req.getParameter(PASSWORD))
                    .dateOfRegistration(new Date())
                    .build();
            service.saveUser(user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute(ERRORS, errors);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }


}
