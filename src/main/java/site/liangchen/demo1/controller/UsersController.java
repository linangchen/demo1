package site.liangchen.demo1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import site.liangchen.demo1.pojo.Users;
import site.liangchen.demo1.service.IUsersService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangchen
 * @since 2018-11-15
 */
@RestController
public class UsersController  {
    private IUsersService usersService;
    @Autowired
    public UsersController(IUsersService usersService){
        this.usersService=usersService;
    }
    @GetMapping("/getUser")
    public Users getUser(){
        return usersService.getById(1);
    }
}
