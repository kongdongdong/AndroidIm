package com.kdd.androidim.web.controller;

import com.kdd.androidim.dao.entity.ImMeun;
import com.kdd.androidim.dao.entity.ImUser;
import com.kdd.androidim.service.ImUserService;
import com.kdd.androidim.web.common.UserInfoSession;
import com.kdd.androidim.web.common.domain.UserInfo;
import com.kdd.androidim.web.common.domain.UserLoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kdd on 17/8/18.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired(required = false)
    private ImUserService userService;

    @RequestMapping(value = "/userlist")
    public ModelAndView userList(UserLoginReq userLoginReq, HttpServletRequest request,
                         HttpServletResponse response, Model model){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo= UserInfoSession.getCurrentUser();
        List<ImMeun> menuList = UserInfoSession.getFromSession(UserInfoSession.MENU_LIST);
        List<ImUser> userList = userService.findAllUser();

        modelAndView.addObject("menuList",menuList);
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.addObject("userList",userList);

        modelAndView.setViewName("user/userlist.jsp");
        return modelAndView;
    }

}
