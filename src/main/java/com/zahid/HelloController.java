package com.zahid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String home(Model model) {
        return new String("Hello Controller");
    }
}


// @Controller
// @ResponseBody
// @RequestMapping("/api")
// public class HelloController {

//     @GetMapping("/hello")
//     public String home(Model model) {
//         return "Hello Controller";
//     }
// }
