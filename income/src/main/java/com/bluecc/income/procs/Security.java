package com.bluecc.income.procs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.income.dao.UserLoginDelegator;
import com.bluecc.income.exchange.GsonConverters;
import com.bluecc.income.exchange.IService;
import com.linecorp.armeria.server.annotation.*;
import io.vavr.control.Try;
import lombok.Builder;
import lombok.Data;
import org.redisson.api.RBloomFilter;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Security implements IService {
    @Inject
    Sequence sequence;
    @Inject
    UserLoginDelegator userLogins;
    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    Algorithm algorithm = Algorithm.HMAC256("secret");
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer("bluecc")
            .acceptLeeway(1) // 1 sec for nbf, iat and exp
            .build(); //Reusable verifier instance

    @Get("/security/token/:loginId")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Try<String> createToken(@Param String loginId){
        return Try.of(()-> {
            String jwtId = sequence.nextStringId();
            // String loginId="DemoBuyer";
            String ownerId = userLogins.get(loginId).getPartyId();

            Map<String, Object> payloadClaims = new HashMap<>();
            payloadClaims.put("@context", "https://bluecc.com/");
            String token = JWT.create()
                    .withIssuer("bluecc")
                    .withExpiresAt(new Date(System.currentTimeMillis() + (7 * DAY_IN_MS)))
                    .withPayload(payloadClaims)
                    .withIssuedAt(new Date())
                    .withJWTId(jwtId)
                    .withClaim("login", loginId)
                    .withClaim("owner", ownerId)
                    .sign(algorithm);
            return token;
        });
    }

    @Data
    @Builder
    public static class UserToken{
        String jwtId;
        String loginId;
        String ownerId;
    }

    public UserToken verifyToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("bluecc")
                .acceptLeeway(1) // 1 sec for nbf, iat and exp
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        // System.out.println("payload: "+jwt.getPayload());

        Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name
        // Claim claim = claims.get("login");
        // System.out.println("login: "+claim.asString());
        return UserToken.builder()
                .jwtId(jwt.getId())
                .loginId(claims.get("login").asString())
                .ownerId(claims.get("owner").asString())
                .build();
    }

    public boolean isInBlacklist(String loginId){
        RBloomFilter<String> blackListFilter = liveObjectsProvider.get().getBlacklistFilter();
        return blackListFilter.contains(loginId);
    }

    public void addToBlacklist(String loginId){
        liveObjectsProvider.get().getBlacklistFilter().add(loginId);
    }
}
