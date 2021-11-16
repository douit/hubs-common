package com.bluecc.domain.dummy.repository;

import com.google.gson.Gson;
import com.bluecc.domain.sql.model.Tweet;
import com.bluecc.domain.sql.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertFalse;

public class ActivityRepositoryTest extends AbstractPersistenceTest{
    @Inject
    private TweetRepository repository;

    @Inject
    private UserRepository userRepository;

    private Long posterId;
    Gson gson=new Gson();

    @Before
    public void setUp() {
        User poster = new User();
        poster.setUsername("dr_frank");
        posterId = userRepository.save(poster);
    }

    @Test
    public void save_and_find_by_username() {
        String content = "I am alive! #YOLO";
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweet.setPosterId(posterId);
        repository.save(tweet);

        assertFalse(repository.findOfUser("dr_frank").isEmpty());

        System.out.println(gson.toJson(tweet));
    }

    @Test
    public void dummy() {

    }
}