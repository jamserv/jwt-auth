package co.com.emidata.security.jwt;

import java.util.Date;

/**
 *
 * @author janez
 */
public interface ITokenManager {

    /**
     *
     * @param username
     * @param expirationDate
     * @return
     */
    public String generate(String username, Date expirationDate);

    /**
     *
     * @param token
     * @return
     */
    public TokenValidation validate(String token);

}
