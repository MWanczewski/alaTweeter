package utils;

import javax.servlet.http.HttpServletRequest;

public class ServletsUtils {
    public static final String LOGIN = "login";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ERRORS = "errors";
    public static final String REMEMBER = "remember";
    public static final String COOKIE_CHECKED = "on";
    public static final String ERROR_LOGIN_HEADER = "Login error";
    public static final String ERROR_EMAIL_HEADER = "Email error";
    public static final String ERROR_LOGIN_REG_MESSAGE = "Typed login is already used";
    public static final String ERROR_EMAIL_REG_MESSAGE = "Typed email is already used";
    public static final String ERROR_LOGIN_MESSAGE = "Login or password is invalid";
    public static final String NOT_FOLLOWED_USERS = "notFollowedUsers";
    public static final String FOLLOWED_USERS = "followedUsers";
    public static final String USER_LOGIN_TO_FOLLOW = "userLoginToFollow";
    public static final String USER_LOGIN_TO_UNFOLLOW = "userLoginToUnfollow";
    public static final String TWEET_MESSAGE_PARAM = "tweetMessage";
    public static final String TWEET_ID_PARAM = "tweetId";
    public static final String FOLLOWED_TWEETS = "tweets";

    public static String getUserLoginFromSession(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(LOGIN);
    }

}
