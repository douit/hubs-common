package com.bluecc.domain.dummy.repository;

import com.bluecc.domain.sql.model.Tweet;
import com.bluecc.domain.sql.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserAndTweets {
    private String username;
    private User user;
    private List<Tweet> tweets;
}
