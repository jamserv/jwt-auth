
package co.com.emidata.confg;

import co.com.emidata.security.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author janez
 */
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    SecurityInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns(
                        "/carriers",
                        "/merchants",
                        "/products/**");
    }
}
