package co.com.emidata.services;

import co.com.emidata.security.jwt.ITokenManager;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author janez
 */
@RestController
@CrossOrigin
public class AuthenticationService {

    @Autowired
    private ITokenManager tokenManager;

    @RequestMapping("/auth/getToken")
    @ResponseBody
    public String getToken_HTTP_GET(@RequestParam("username") String username) {
        long t = System.currentTimeMillis();
        return tokenManager.generate(username, new Date(t * 2));
    }

}
