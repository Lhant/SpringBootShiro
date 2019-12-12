package com.zqk.service.userServiceImpl;

import com.zqk.pojo.Perms;
import com.zqk.pojo.User;
import com.zqk.service.permService;
import com.zqk.service.userService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userServiceImplTest {

    @Autowired
    private userService userService;
    @Autowired
    private permService permService;
    @Test
    public void test(){
        User user = userService.selectByUserName("zqk2004");
        List<Perms> perms = permService.perms("zqk2004");
        String userpassword = user.getUserpassword();
        String s="";
        for (Perms x:perms) {
            s=s+x.toString()+"   ";
        }

//        for (int i = 0; i <perms.size() ; i++) {
//            s=s+perms.get(i).toString()+"   ";
//        }
        System.out.println(user.getUsername()+"    "+userpassword+"   "+s);

    }

}