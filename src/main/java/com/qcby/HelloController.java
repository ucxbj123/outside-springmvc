package com.qcby;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value="/hello.do")
    public String sayHello(Model model){
        System.out.println("入门方法执行222");
        model.addAttribute("msg","hello,Springmvc");
        return "suc";
    }
}