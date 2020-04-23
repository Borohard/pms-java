package org.usersandclaims;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping(value = "/", produces = "text/html; charset = UTF-8")
    public String getMainPage() {
        return "index";
    }


}
