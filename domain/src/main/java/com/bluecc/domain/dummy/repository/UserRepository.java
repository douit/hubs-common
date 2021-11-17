package com.bluecc.domain.dummy.repository;

import com.bluecc.domain.sql.model.Tweet;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.bluecc.domain.dummy.guice.Transactional;
import com.bluecc.domain.sql.model.User;
import com.querydsl.core.types.QBean;

import java.util.List;

import static com.bluecc.domain.sql.model.QTweet.tweet;
import static com.bluecc.domain.sql.model.QUser.user;
import static com.querydsl.core.types.Projections.bean;

public class UserRepository extends AbstractRepository {
    @Transactional
    public User findById(Long id) {
        return selectFrom(user).where(user.id.eq(id)).fetchOne();
    }

    @Transactional
    public Long save(User entity) {
        if (entity.getId() != null) {
            update(user).populate(entity).execute();
            return entity.getId();
        }
        return insert(user).populate(entity)
                .executeWithKey(user.id);
    }

    @Transactional
    public List<UserInfo> allWithTweetCount() {
        return select(Projections.constructor(UserInfo.class, user.username, tweet.id.count())).from(user)
                .leftJoin(tweet).on(user.id.eq(tweet.posterId))
                .groupBy(user.username)
                .fetch();
    }

    final QBean<Tweet> tweetBean = bean(Tweet.class, tweet.all());
    final QBean<UserAndTweets> userBean = bean(UserAndTweets.class,
            user.id, user.username,
            bean(User.class, user.all()).as("user"),
            GroupBy.list(tweetBean).as("tweets"));

    @Transactional
    public List<UserAndTweets> allUserAndTweets(){
        return selectFrom(user)
                .leftJoin(tweet).on(user.id.eq(tweet.posterId))
                .transform(GroupBy.groupBy(user.id).list(userBean));
    }

    @Transactional
    public List<User> findAll(Predicate expr) {
        return selectFrom(user).where(expr).fetch();
    }

    @Transactional
    public List<User> all() {
        return selectFrom(user).fetch();
    }

}
