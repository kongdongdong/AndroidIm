package com.kdd.androidim.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ddkong on 2017/9/7.
 */
@RestController
@RequestMapping(value = "/system")
public class SystemController {

    @RequestMapping(value = "/changepwd")
    public ModelAndView changePwdView(HttpServletRequest request, HttpServletResponse response, Model model){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("system/changepwd.jsp");

        return modelAndView;
    }


}
