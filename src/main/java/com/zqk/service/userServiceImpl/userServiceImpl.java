package com.zqk.service.userServiceImpl;

import com.zqk.dao.UserMapper;
import com.zqk.pojo.User;
import com.zqk.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class userServiceImpl implements userService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String userName) {
        User list = userMapper.selectByUserName(userName);
        return list;
    }
}
