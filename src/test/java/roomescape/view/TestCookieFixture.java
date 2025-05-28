package roomescape.view;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;
import roomescape.global.jwt.JwtProperties;
import roomescape.member.domain.Role;

@Component
public class TestCookieFixture {

    private static final String COOKIE_NAME = "token";
    private static final Long TEST_MEMBER_ID = 1L;

    private final JwtProperties jwtProperties;

    public TestCookieFixture(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public Cookie createCookieWith(final Role role) {
        String token = createTestToken(role);
        return new Cookie(COOKIE_NAME, token);
    }

    private String createTestToken(final Role role) {
        return Jwts.builder()
                .claim("id", TEST_MEMBER_ID)
                .claim("role", role)
                .setExpiration(jwtProperties.createExpire())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }
}
