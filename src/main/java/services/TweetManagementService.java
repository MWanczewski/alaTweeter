package services;

import model.Tweet;

import java.util.Set;

public interface TweetManagementService {
    void addTweet(String userLogin, String message);

    void updateTweet(Long tweetId, String message);

    void deleteTweet(Long id);

    Set<Tweet> getFollowedTweets(String userLogin);
}
