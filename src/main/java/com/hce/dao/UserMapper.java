package com.hce.dao;

import com.hce.entity.param.UserQueryParam;
import com.hce.entity.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:18
 * @modified by:
 */
@Mapper
@Repository
public interface UserMapper {

    String PUBLIC_COLUMN = "id,username,password,updated_time,created_time,updated_by,created_by";

    @Options(useGeneratedKeys = true)
    @Insert("insert into user(username,password,created_time,created_by)" +
            " values(#{username},#{password},now(),#{createdBy})")
    long insert(User user);

    @Update("delete from user where username=#{username}")
    void delete(String username);

    @Update("update user set username=#{username},password=#{password},updated_by=#{updatedBy},updated_time=now()" +
            " where id=#{id}")
    void update(User user);

    @Select("select " + PUBLIC_COLUMN + " from user where username=#{username}")
    User select(String username);

    @Select("<script>" +
            "select " + PUBLIC_COLUMN +
            " from user" +
            " where 1=1" +
            "<if test='username!=null'>" +
            " and username = #{username}" +
            "</if>" +
            "<if test='password != null'>" +
            " and password = #{password}" +
            "</if>" +
            "</script>")
    List<User> query(UserQueryParam userQueryParam);
}
