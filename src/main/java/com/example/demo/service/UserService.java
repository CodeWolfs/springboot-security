package com.example.demo.service;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mapper.UserMapper;
import org.springframework.security.access.annotation.Secured;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzhe
 * @since 2022-05-12
 */
public interface UserService extends IService<User> {
//    @Secured({"ROLE_sale"})
    List<Map<String,Object>> getUserList();

}
