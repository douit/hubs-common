package com.bluecc.income.dao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.stub.Indicator;
import com.bluecc.hubs.stub.UserLoginData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.procs.GenericProcs;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.redisson.api.RSetMultimapCache;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.bluecc.hubs.fund.Util.prettyFull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UserLoginDelegatorTest extends AbstractStoreProcTest {
    @Inject UserLoginDelegator userLogins;

    @Before
    public void setUp() throws Exception {
        setupEntities("UserLogin");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            UserLoginFlatData flatData= UserLoginFlatData.newBuilder()
                    .setUserLoginId(newId)
                    .setPasswordHint(faker.hipster().word())
                    .build();
            assertEquals(1, userLogins.create(ctx, flatData));
            assertEquals(1, userLogins.update(ctx, flatData));
            assertEquals(1, userLogins.find(ctx, flatData).size());
            assertEquals(1, userLogins.findById(ctx, flatData).size());
            assertEquals(1, userLogins.delete(ctx, flatData));
            assertEquals(0, userLogins.find(ctx, flatData).size());
        });
    }

    public final static UserLoginFlatData UserLogin_samlet = UserLoginFlatData.newBuilder()
            .setPartyId("samlet")
            .setUserLoginId("samlet")
            .build();

    @Test
    public void testStoreUserLogin() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            userLogins.create(c, UserLogin_samlet);
        });
    }

    @Test
    public void testUpdateUserLogin() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            userLogins.storeOrUpdate(c, UserLoginFlatData
                    .newBuilder(UserLogin_samlet)
                    .setEnabled(Indicator.YES)
                    .build());
        });
    }

    @Test
    public void loadSeedData(){
        GenericProcs.loadDataSet("dataset/livecases/SecurityExtDemoData.xml")
                .get("UserLogin")
                .forEach(r -> System.out.println(r));
    }
    @Test
    public void testStoreSecurityData() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            genericProcs.storeDataFile(c, "dataset/livecases/SecurityExtDemoData.xml");
        });
    }

    @Test
    public void testAllLogins() {
        process(c -> {
            //Dao dao = c.getHandle().attach(//Dao.class);
            userLogins.all(c).forEach(u -> {
                prettyFull(u);
            });
        });
    }

    @Inject
    LiveObjects liveObjects;
    @Test
    public void testCreateToken(){
        RSetMultimapCache<String, String> multimap = liveObjects.redisson()
                .getSetMultimapCache("tokens");
        // String loginId="DemoBuyer";
        String loginId="admin";
        System.out.println("passwd: "+userLogins.get(loginId).getCurrentPassword());
        multimap.put(loginId, sequence.nextStringId());
        // ????????????token????????????, ???cache????????????????????????token-ids, ??????????????????????????????id,
        // ???????????????token????????????
        multimap.expireKey(loginId, 10, TimeUnit.HOURS);

        multimap.getAll(loginId).forEach(e -> System.out.println(e));
        System.out.println(userLogins.get(loginId));
        System.out.println("login-party: "+userLogins.get(loginId).getPartyId());
    }

    Algorithm algorithm = Algorithm.HMAC256("secret");
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    @Test
    public void testJwt(){
        try {
            String jwtId=sequence.nextStringId();
            String loginId="DemoBuyer";
            String ownerId=userLogins.get(loginId).getPartyId();

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
            System.out.println("token: "+token);
            System.out.println("length: "+token.length());
            
            verifyToken(token);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            fail(exception.getMessage());
        }

    }

    private void verifyToken(String token) {
        try {
            // Algorithm algorithm = Algorithm.HMAC256("secret");
            // ??????????????????????????????????????????????????????????????????????????? JWTVerificationException???
            // ??????????????????????????????????????????????????????????????????????????? ?????????????????? Token ??????????????????????????????
            // ????????? JWTVerifier ??????????????? acceptLeeway() ???????????????????????????
            // ??????????????????????????????????????????
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("bluecc")
                    .acceptLeeway(1) // 1 sec for nbf, iat and exp
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("payload: "+jwt.getPayload());

            Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name
            Claim claim = claims.get("login");
            System.out.println("login: "+claim.asString());
            System.out.println("all keys: "+claims.keySet());
            System.out.println("jwt id: "+jwt.getId());
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            fail(exception.getMessage());
        }
    }
}
