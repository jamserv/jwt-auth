package co.com.emidata.security;

import co.com.emidata.constants.AppSecurityConst;
import co.com.emidata.security.jwt.ITokenManager;
import co.com.emidata.security.jwt.TokenValidation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author janez
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ITokenManager tokenManager;

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("call::SecurityInterceptor::HandlerInterceptorAdapter");
        try {
            String tokenHeader = request.getHeader(AppSecurityConst.HEADER_X_TOKEN);
            TokenValidation validation = tokenManager.validate(tokenHeader);
            if (validation.isValid()) {
                return super.preHandle(request, response, handler);
            }

            response.setContentType(AppSecurityConst.APPLICATION_JSON);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(401);
            String jsonResponse = "invalid token";
            response.getWriter().write(jsonResponse);
        } catch (java.lang.NullPointerException e) {
            System.err.println("No header param available.");
        }
        return Boolean.FALSE;
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     *
     * @param request
     * @param response
     * @param handle
     * @param exception
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handle, Exception exception) throws Exception {
        super.afterCompletion(request, response, handle, exception);
    }

}
