package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzhe
 * @since 2022-05-12
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getUserList() {
        Page<Map<String,Object>> page = new Page<>(0,10);
        Page<Map<String, Object>> mapPage = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = mapPage.getRecords();
        for (Map<String, Object> a:
        records){
            System.out.println(a);
        }

        return records;
    }
}
