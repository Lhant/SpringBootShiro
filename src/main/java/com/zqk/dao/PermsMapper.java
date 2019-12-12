package com.zqk.dao;

import com.zqk.pojo.Perms;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface PermsMapper {
    List<Perms> selectPermsByName(String name);

    int deleteByPrimaryKey(Integer permid);

    int insert(Perms record);

    int insertSelective(Perms record);

    Perms selectByPrimaryKey(Integer permid);

    int updateByPrimaryKeySelective(Perms record);

    int updateByPrimaryKey(Perms record);
}