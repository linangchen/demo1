package site.liangchen.demo1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username,@RequestParam String password){
        //获取subject
        Subject subject=SecurityUtils.getSubject();
       if (!subject.isAuthenticated()) {
           UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
           try {
               SecurityUtils.getSubject().login(token);
           }catch (UnknownAccountException uae){
               System.out.println("没有该用户");
               return "redirect:/login";
           }catch (IncorrectCredentialsException ice){
               System.out.println("密码错误");
               return "redirect:/login";
           }catch (LockedAccountException lae){
               System.out.println("用户被锁定");
               return "redirect:/login";
           }
           catch (Exception e) {
               e.printStackTrace();
               return "redirect:/login";

           }

       }
        try {
            username=subject.getSession().getAttribute("userName").toString();
        }catch (NullPointerException e){
            subject.getSession().setAttribute("userName",username);
        }
        return "redirect:/admin";

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        Subject us=SecurityUtils.getSubject();
        String username="";
        try {
            username=us.getSession().getAttribute("userName").toString();
        }catch (NullPointerException e){
            return "redirect:/login";
        }
        model.addAttribute("name",username);
        return "admin";

    }
    @GetMapping("/logout")
    public String doLogout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }


    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/root")
    public String root(){
        return "root";
    }
}
