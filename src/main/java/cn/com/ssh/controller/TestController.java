package cn.com.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/return")
    @ResponseBody
    public String testReturn() {
        return "test";
    }
}
