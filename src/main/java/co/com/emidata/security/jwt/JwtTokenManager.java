package co.com.emidata.security.jwt;

import io.jsonwebtoken.*;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author janez
 */
@Service
public class JwtTokenManager implements ITokenManager {

    private String secret = "janez";

    @Override
    public String generate(String username, Date expirationDate) {

        String token = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(expirationDate)
                .compact();

        return token;
    }

    @Override
    public TokenValidation validate(String token) {
        TokenValidation tv = new TokenValidation();
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String username = body.getSubject();
            tv.setValid(true);
            tv.setUsername(username);
            return tv;
        } catch (SignatureException ex) {
            System.err.println(ex.getLocalizedMessage());
            tv.setValid(false);
            tv.setValidationErrorType(TokenValidation.ValidationErrorType.UNAUTHORIZED_USER);
            return tv;
        } catch (ExpiredJwtException ex) {
            System.err.println(ex.getLocalizedMessage());
            tv.setValid(false);
            tv.setValidationErrorType(TokenValidation.ValidationErrorType.EXPIRED_TOKEN);
            return tv;
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            tv.setValid(false);
            tv.setValidationErrorType(TokenValidation.ValidationErrorType.UNAUTHORIZED_USER);
            return tv;
        }
    }
}
