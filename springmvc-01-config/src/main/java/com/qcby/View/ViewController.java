package com.qcby.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
    /**
     * thymeleafview、InternalResourcesView、RedirectView测试:
     * 在springmvc.xml配置thymeleafview视图解析器的前提下
     * return "" 如果不加前缀forward与redirect则是调用配置从视图解析器thymeleafview
     */

    @RequestMapping("/test_view")
    public String test_view(){
        return "html/test_view";
    }

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "formdate";
    }

    @RequestMapping("/testForward")
    public String testForWard(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testForward";
    }

//    @RequestMapping("ad")
//    public String testViewController(){
//        return "redirect:/html/suc.html";
//    }
}
