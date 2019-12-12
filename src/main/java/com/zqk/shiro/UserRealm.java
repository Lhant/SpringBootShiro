package com.zqk.shiro;

import com.zqk.pojo.Perms;
import com.zqk.pojo.User;
import com.zqk.service.permService;
import com.zqk.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private userService userService;
    @Autowired
    private permService permService;
    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //查询权限 // prem写成perm了，不影响查看
        List<Perms> permAll = permService.perms(user.getUsername());
        List<String> prems=new ArrayList<>();

        for (int i = 0; i <permAll.size() ; i++) {
            prems.add(permAll.get(i).getPermstring());
            System.out.println(permAll.size()+"    "+permAll.get(i).getPermstring());

        }
//        prems.add(perm);
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        info.addStringPermissions(prems);
        return info;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //假设数据库的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.selectByUserName(token.getUsername());
        if (user==null){
            //用户名不存在
            //shiro底层会抛出UnKnowAccountException
            return null;
        }

        //SimpleHash simpleHash = new SimpleHash("MD5",password,null,1024);
        //System.out.println(simpleHash);
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        //2.判断密码
        return new SimpleAuthenticationInfo(user,user.getUserpassword(),"");
    }
}



