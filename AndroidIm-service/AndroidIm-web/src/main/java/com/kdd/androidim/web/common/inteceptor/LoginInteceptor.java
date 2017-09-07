package com.kdd.androidim.web.common.inteceptor;

import com.kdd.androidim.web.common.UserInfoSession;
import com.kdd.androidim.web.common.domain.BaseResponse;
import com.kdd.androidim.web.common.domain.UserInfo;
import com.kdd.androidim.web.common.domain.WebGlobalVo;
import com.kdd.androidim.web.common.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by kdd on 17/8/31.
 */
public class LoginInteceptor extends HandlerInterceptorAdapter {

    public static Logger logger = LoggerFactory.getLogger(LoginInteceptor.class);


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = UserInfoSession.getCurrentUser();
        String uri = request.getRequestURI();

        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ResponseBody hasResponseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
            if(userInfo==null){
                if(hasResponseBody != null) {
                    BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_SESSION,0,"登录超时,请重新登录");
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-type","text/html;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(baseResp.toString());
                    logger.info("\n用户访问url={} 因未登陆或session过期, 返回超时错误信息:{}", uri, baseResp);
                } else {
                    logger.info("\n用户访问url={} 因未登陆或session过期, 强制跳转到tologin登陆页", uri);
                    response.sendRedirect(request.getContextPath() + "/login");
                }
                return false;
            }else {
                //权限校验,暂时没有

            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null){
            String uri = request.getRequestURI();
            if(uri.startsWith("/")){
                uri = uri.substring(1,uri.length());
            }
            WebGlobalVo webGlobalVo = new WebGlobalVo();
            webGlobalVo.setCurrentUrl(uri);

            int end = uri.lastIndexOf("/");
            if(end!=-1 && end<=uri.length()){
                String parentCurrentUrl = uri.substring(0,end);
                webGlobalVo.setParentCurrentUrl(parentCurrentUrl);
            }
            UserInfo userInfo=UserInfoSession.getCurrentUser();
            modelAndView.addObject("webGlobalVo",webGlobalVo);
            modelAndView.addObject("userInfo",userInfo);
        }
    }
}
