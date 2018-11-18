package site.liangchen.demo1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.liangchen.demo1.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liangchen
 * @since 2018-11-15
 */
@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
