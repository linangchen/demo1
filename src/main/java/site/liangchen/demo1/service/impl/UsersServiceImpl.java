package site.liangchen.demo1.service.impl;

import site.liangchen.demo1.pojo.Users;
import site.liangchen.demo1.mapper.UsersMapper;
import site.liangchen.demo1.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangchen
 * @since 2018-11-15
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
