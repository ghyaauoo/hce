package com.hce.dao;

import com.hce.entity.param.UserQueryPageParam;
import com.hce.entity.param.UserQueryParam;
import com.hce.entity.po.User;
import com.hce.entity.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
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

    @Results(id = "userVo", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "balance", property = "balance", jdbcType = JdbcType.VARCHAR),
            @Result(column="id", property="chargeLogVoList", javaType=List.class,
                    many=@Many(select="com.hce.dao.ChargeLogMapper.queryByUserId"))
    })
    @Select("<script>" +
            "select u.id,u.username,date_format(u.created_time,'%Y-%m-%d %H:%i:%s') as created_time,u.created_by,a.balance" +
            " from user u" +
            " left join account a on u.id = a.user_id" +
            " where 1=1" +
            "<if test='username!=null'>" +
            " and u.username like #{username}" +
            "</if>" +
            "</script>")
    List<UserVo> queryByPage(UserQueryPageParam userQueryPageParam);
}
