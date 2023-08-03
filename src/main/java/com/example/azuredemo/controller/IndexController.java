package com.example.azuredemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认控制器
 * @author 37152
 */
@RestController
public class IndexController {

    /**
     *
     * @return
     */
    @GetMapping
    public String index(){
        return "AzureDemo";
    }

}
