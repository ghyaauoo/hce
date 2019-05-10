package com.hce.dao;

import com.hce.entity.po.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:29
 * @modified by:
 */
@Mapper
@Repository
public interface AccountMapper {

    String PUBLIC_COLUMN = "id,user_id,balance,updated_time,created_time,updated_by,created_by";

    @Options(useGeneratedKeys = true)
    @Insert("insert into account(user_id,balance,created_time,created_by)" +
            " values(#{userId},#{balance},now(),#{createdBy})")
    long insert(Account account);

    @Update("delete from account where user_id=#{userId}")
    void delete(long userId);

    @Update("update account set user_id=#{userId},balance=#{balance},updated_by=#{updatedBy},updated_time=now()" +
            " where id=#{id}")
    void update(Account account);

    @Results(id = "account", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updated_time", property = "updatedTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "balance", property = "balance", jdbcType = JdbcType.VARCHAR),
    })
    @Select("select " + PUBLIC_COLUMN + " from account where user_id=#{userId}")
    Account select(long userId);

}
