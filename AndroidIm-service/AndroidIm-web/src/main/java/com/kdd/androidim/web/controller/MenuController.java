package com.kdd.androidim.web.controller;

import com.kdd.androidim.dao.entity.ImMeun;
import com.kdd.androidim.service.ImMenuService;
import com.kdd.androidim.web.common.domain.UserLoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kdd on 17/9/5.
 */
@RestController
public class MenuController {

    @Autowired(required = false)
    private ImMenuService imMenuService;


    @RequestMapping(value = "/mymenu")
    public List<ImMeun>  userUogin(UserLoginReq userLoginReq, HttpServletRequest request,
                                          HttpServletResponse response, Model model){
        List<ImMeun> menuList =  imMenuService.findMenuByUsername("kdd");

        return menuList;
    }

}
