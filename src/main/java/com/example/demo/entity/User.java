package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author WangZhe
 * @Date 2022/4/15 9:57
 * @Version 1.0
 */

@Data
public class User {
    @TableId(value = "id")
    private Integer id;
    private String username;
    private String password;
}
