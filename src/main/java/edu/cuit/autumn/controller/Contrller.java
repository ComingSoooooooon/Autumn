package edu.cuit.autumn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Contrller {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "liuxin");
        return "home";
    }
    @RequestMapping("/tologin")
    public String tologin(HttpServletRequest request, Model model) {
        if(request.getParameter("username")==null){
            return "login";
        }else {
            try {
                String name = "root";
                String pwd = "123456";
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (username.equals("root") && password.equals("123456")) {
                    model.addAttribute("message","欢迎你");
                    return "home";
                } else {
                    model.addAttribute("message","用户名或密码错误");
                    return "login";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }
}