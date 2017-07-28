package co.com.emidata.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author janez
 */
@RestController
@CrossOrigin
public class ProductsService {

    @RequestMapping("/products/findProducts")
    @ResponseBody
    public String findProducts_HTTP_GET() {
        return "ok/allProducts";
    }
}
