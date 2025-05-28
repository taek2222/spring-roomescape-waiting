package roomescape.global.jwt;

import java.util.Date;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security.jwt.token")
public class JwtProperties {

    private String secretKey;
    private Long expireLength;

    public Date createExpire() {
        return new Date(System.currentTimeMillis() + expireLength);
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setExpireLength(Long expireLength) {
        this.expireLength = expireLength;
    }
}
