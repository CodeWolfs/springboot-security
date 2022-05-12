package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzhe
 * @since 2022-05-12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    @Secured({"ROLE_admin", "ROLE_manager"})
    @PostFilter("filterObject.get('username') == 'admin'")
    public List<Map<String, Object>> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/user")
    @ResponseBody
//    @PreAuthorize("hasAnyAuthority('admin') and hasAnyRole('ROLE_manager')")
    @PostAuthorize("hasAnyRole('ROLE_manager') and hasAnyAuthority('tian')")
    public User getUser() {
        return userService.getById(1);
    }


}
