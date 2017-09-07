package com.kdd.androidim.web.controller;

import com.kdd.androidim.dao.entity.ImMeun;
import com.kdd.androidim.dao.entity.ImUser;
import com.kdd.androidim.service.ImMenuService;
import com.kdd.androidim.service.ImUserService;
import com.kdd.androidim.web.common.UserInfoSession;
import com.kdd.androidim.web.common.domain.BaseResponse;
import com.kdd.androidim.web.common.domain.UserInfo;
import com.kdd.androidim.web.common.domain.UserLoginReq;
import com.kdd.androidim.web.common.exception.BizException;
import com.kdd.androidim.web.common.exception.ExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kdd on 17/8/31.
 */
@RestController
public class LoginController {


    @Autowired(required = false)
    private ImUserService imUserService;

    @Autowired(required = false)
    private ImMenuService imMenuService;

    @RequestMapping(value = "/login")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/userlogin")
    public BaseResponse<String> userUogin(UserLoginReq userLoginReq, HttpServletRequest request,
                                          HttpServletResponse response, Model model){
        BaseResponse<String> baseResponse = new BaseResponse<String>(1,"登陆成功");
        try {
            if(userLoginReq==null){
                BizException.warn501(0, "参数不全");
            }
            if(userLoginReq.getLoginName()==null || StringUtils.isEmpty(userLoginReq.getLoginName())){
                BizException.warn501(0, "用户名为空");
            }
            ImUser imUser = imUserService.getImUserByUserName(userLoginReq.getLoginName());
            if(imUser==null){
                BizException.warn(0, "用户不存在");
            }
            if(!imUser.getPassword().equals(userLoginReq.getPassword())){
                BizException.warn(0, "密码不正确");
            }
            List<ImMeun> menuList = UserInfoSession.getFromSession(UserInfoSession.MENU_LIST);
            if(menuList==null || menuList.size()==0){
                //获取用户所有的菜单
                menuList =  imMenuService.findMenuByUsername(imUser.getUsername());
                UserInfoSession.save2Session(UserInfoSession.MENU_LIST,menuList);
            }
            //登录成功，把用户信息放入session里面
            saveUserinfo(imUser);
        }catch (Exception e){
            baseResponse = ExceptionHelper.createResponse(e);
        }

        return baseResponse;
    }


    private void saveUserinfo(ImUser imUser) {
        UserInfo usersession = new UserInfo();
        usersession.setId(imUser.getId());
        usersession.setAddress(imUser.getAddress());
        usersession.setBirthday(imUser.getBirthday());
        usersession.setCity(imUser.getCity());
        usersession.setDistrict(imUser.getDistrict());
        usersession.setEmail(imUser.getEmail());
        usersession.setNickname(imUser.getNickname());
        usersession.setPhone(imUser.getPhone());
        usersession.setPortrait(imUser.getPortrait());
        usersession.setProvince(imUser.getProvince());
        usersession.setSex(imUser.getSex());
        usersession.setUsername(imUser.getUsername());
        UserInfoSession.setCurrentUser(usersession);
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        UserInfoSession.removeSession();
        UserInfoSession.removeFromSession(UserInfoSession.MENU_LIST);
        ModelAndView modelAndView = new ModelAndView("redirect:login");
        return modelAndView;
    }


    /**
     * <p>登陆成功，访问首页</p>
     * @param @return
     * @return String
     */
    @RequestMapping(value = "/home")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        List<ImMeun> menuList = UserInfoSession.getFromSession(UserInfoSession.MENU_LIST);

        modelAndView.addObject("menuList",menuList);
        modelAndView.setViewName("home.jsp");
        return modelAndView;
    }
}
