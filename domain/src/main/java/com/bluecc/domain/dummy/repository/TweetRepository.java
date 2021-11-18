package com.bluecc.domain.dummy.repository;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.sql.model.Tweet;
import com.bluecc.domain.sql.model.TweetUser;
import com.querydsl.sql.dml.SQLInsertClause;

import java.util.List;

import static com.bluecc.domain.sql.model.QLocation.location;
import static com.bluecc.domain.sql.model.QTweet.tweet;
import static com.bluecc.domain.sql.model.QTweetUser.tweetUser;
import static com.bluecc.domain.sql.model.QUser.user;

public class TweetRepository extends AbstractRepository {
    @Transactional
    public Long save(Tweet entity) {
        if (entity.getId() != null) {
            update(tweet).populate(entity).execute();
            return entity.getId();
        }
        // return insert(tweet).populate(entity)
        //         .executeWithKey(user.id);
        return insert(tweet).populate(entity)
                .executeWithKey(tweet.id);
    }

    @Transactional
    public Long save(Tweet tweet, Long... mentions) {
        Long tweetId = save(tweet);
        SQLInsertClause insert = insert(tweetUser);
        for (Long mentionsId : mentions) {
            TweetUser tu = new TweetUser();
            tu.setTweetId(tweetId);
            tu.setMentionsId(mentionsId);
            insert.populate(tu).addBatch();
        }
        insert.execute();
        return tweetId;
    }

    @Transactional
    public Tweet findById(Long id) {
        return selectFrom(tweet).where(tweet.id.eq(id)).fetchOne();
    }

    @Transactional
    public List<Tweet> findOfUser(String username) {
        return select(tweet).from(user)
                .innerJoin(tweet).on(tweet.posterId.eq(user.id))
                .fetch();
    }

    @Transactional
    public List<Tweet> findWithMentioned(Long userId) {
        return selectFrom(tweet)
                .innerJoin(tweetUser).on(tweet.id.eq(tweetUser.tweetId))
                .where(tweetUser.mentionsId.eq(userId))
                .fetch();
    }

    @Transactional
    public List<Tweet> findOfArea(double[] pointA, double[] pointB) {
        return selectFrom(tweet)
                .innerJoin(location).on(tweet.locationId.eq(location.id))
                .where(location.longitude.between(pointA[0], pointB[0]),
                       location.latitude.between(pointA[1], pointB[1]))
                .fetch();
    }

    @Transactional
    public List<Tweet> findAll(Predicate expr) {
        return selectFrom(tweet).where(expr).fetch();
    }
}
