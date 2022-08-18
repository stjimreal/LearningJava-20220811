package com.exampleLLJ.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/18 15:56
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "main";
    }
}
