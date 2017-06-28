package com.springmvc.controller;

import com.springmvc.common.SpringMvcActionContext;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.springmvc.util.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huanghaojian on 17/6/25.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends SpringMvcActionContext{
    @Resource
    private UserService userService;

    /*注册*/
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public @ResponseBody void register(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        HttpSession session=getSession();
        String userAccount=request.getParameter("userAccount");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserAccount(userAccount);
        user.setPassword(password);
        User user1=userService.selectByPrimaryKey(userAccount);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (user1 != null) {
            out.println(0);
        } else {
            int result = userService.register(user);
            if (result >= 0) {
                out.println(1);
            } else {
                out.println(2);
            }
        }
        out.flush();
        out.close();
    }

    /* 登录*/

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public void login(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        HttpSession session=getSession();
        String userAccount=request.getParameter("userAccount");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserAccount(userAccount);
        user.setPassword(password);
        User user1=userService.login(user);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (user1 == null) {
            out.println(0);
        } else if (user1.getState()!=0){
            out.println(1);
        }
        else if (password.equals(user1.getPassword())){
            out.println(2);
            session.setAttribute("user",user1);
            System.out.println(
                    "session 中的user" + session.getAttribute("user")
            );
        }
        out.flush();
        out.close();
    }
    //登出
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public Object logout(HttpServletRequest request){
        HttpSession session=getSession();
        String userAccount=request.getParameter("userAccount");
        User user=userService.selectByPrimaryKey(userAccount);
        user.setState(0);
        session.removeAttribute("user");
        return  MyResult.getResult();
    }

    @RequestMapping(value="/show",method= RequestMethod.GET)
    public @ResponseBody User show(HttpServletRequest request, Model model){
        String userAccount=request.getParameter("userAccount");
        User user=userService.selectByPrimaryKey(userAccount);
        model.addAttribute("user",user);
        return user;
    }


}
