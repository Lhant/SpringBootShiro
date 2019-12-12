package com.zqk.service.userServiceImpl;

import com.zqk.dao.PermsMapper;
import com.zqk.pojo.Perms;
import com.zqk.service.permService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permService")
public class permServiceImpl implements permService {

    @Autowired
    private PermsMapper permsMapper;
    @Override
    public List<Perms> perms(String name) {
        List<Perms> perms = permsMapper.selectPermsByName(name);
        return perms;
    }
}
