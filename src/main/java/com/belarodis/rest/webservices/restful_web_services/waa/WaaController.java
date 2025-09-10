package com.belarodis.rest.webservices.restful_web_services.waa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //1st step
public class WaaController {

    //@RequestMapping(method = RequestMethod.GET, path = "/waa") //2nd step, mapeia esse request como GET e declara o path p/ acesso
    @GetMapping(path = "/waa") //2nd step, metodo ja declara que é GET e declara o path p/ acesso
    public String waa() {
        return "Waaaa!!";
    }

    @GetMapping(path = "/waa-bean")
    public WaaBean waaBean() {
        return new WaaBean("Waaaa Beeean!!");
    }

    @GetMapping(path = "/waa-bean/{name}")
    public WaaBean waaPathVariable(@PathVariable String name) {
        return new WaaBean(String.format("Waaaa Beeean!! %s", name));
        //return new WaaBean("Waaaa Beeean!! " + name);
    }
}
