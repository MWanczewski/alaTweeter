package dao;

import model.AppUser;
import model.Tweet;

import java.util.List;

public interface TweetDAO {
    void addTweet(AppUser user, String message);

    void updateTweet(Long tweetId, String message);

    void deleteTweet(Long tweetId);

    List<Tweet> getUserTweets(String userLogin);
}
