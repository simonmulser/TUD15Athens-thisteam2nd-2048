package com.thisteam2nd.game2048;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by PaalKristian on 17/03/2017.
 */
public class TwitterObserver implements GameObserver {

    public void update() {
        if (Logic.isGameOver(Game.getInstance().getValues())) {
            try {
                ConfigurationBuilder cb = new ConfigurationBuilder();
                // This is of course not real secrets ;)
                cb.setDebugEnabled(true)
                        .setOAuthConsumerKey(TwitterCredentials.getOAuthConsumerKey())
                        .setOAuthConsumerSecret(TwitterCredentials.getOAuthConsumerSecret())
                        .setOAuthAccessToken(TwitterCredentials.getOAuthAccessToken())
                        .setOAuthAccessTokenSecret(TwitterCredentials.getOAuthAccessTokenSecret())
                        .setUser(TwitterCredentials.getUser());
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();
                int score = Game.getInstance().getScore();
                twitter.updateStatus(TwitterCredentials.getMessage(score));
            } catch (Exception e) {
                System.out.println("Unable to publish tweet.");
                System.out.println(e);
            }
        }
    }
}
