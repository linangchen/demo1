package site.liangchen.demo1.service;

import site.liangchen.demo1.pojo.Permission;
import site.liangchen.demo1.pojo.Role;
import site.liangchen.demo1.pojo.User;

public interface AccountService {
    User getuserByName(String name);
    User getUserById(int id);
    Role getRoleById(int id);
    Permission getPermissionByRoleId(int id);
}
