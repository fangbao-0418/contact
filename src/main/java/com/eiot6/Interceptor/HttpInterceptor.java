package com.eiot6.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpInterceptor extends HandlerInterceptorAdapter {
    private void returnJson (HttpServletResponse response, String result) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(result);

        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("前置拦截器1 preHandle： 请求的uri为："+requestURL.toString());
        // response.setStatus(401, "XXXX");
        // response.
        // returnJson(response, ResultUtil.error(401, "xxxx").toString());
        // returnJson(response, "xxx");
        // ResultUtil.error(401, "xxxx");
        return true;
        // return 2;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1 postHandle： ");
        // return "2";
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器1 afterCompletion： ");
        // return "2";
    }
}
