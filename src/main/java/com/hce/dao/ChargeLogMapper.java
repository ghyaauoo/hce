package com.hce.dao;

import com.hce.entity.form.ChargeLogQueryForm;
import com.hce.entity.param.ChargeLogQueryParam;
import com.hce.entity.po.ChargeLog;
import com.hce.entity.vo.ChargeLogPageVo;
import com.hce.entity.vo.ChargeLogVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:30
 * @modified by:
 */
@Mapper
@Repository
public interface ChargeLogMapper {

    String PUBLIC_COLUMN = "id,user_id,charge,updated_time,created_time,updated_by,created_by";

    @Options(useGeneratedKeys = true)
    @Insert("insert into charge_log(user_id,charge,created_time,created_by)" +
            " values(#{userId},#{charge},now(),#{createdBy})")
    long insert(ChargeLog chargeLog);

    @Update("delete from charge_log where user_id=#{userId}")
    void delete(long userId);

    @Update("update charge_log set user_id=#{userId},charge=#{charge},updated_by=#{updatedBy},updated_time=now()" +
            " where id=#{id}")
    void update(ChargeLog chargeLog);

    @Results(id = "chargeLog", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updated_time", property = "updatedTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "charge", property = "charge", jdbcType = JdbcType.VARCHAR),
    })
    @Select("select " + PUBLIC_COLUMN + " from charge_log where user_id=#{userId}")
    ChargeLog select(long userId);

    @Select("<script>" +
            "select " + PUBLIC_COLUMN +
            " from charge_log" +
            " where 1=1" +
            "<if test='userId!=null'>" +
            " and user_id = #{userId}" +
            "</if>" +
            "</script>")
    @ResultMap(value = "chargeLog")
    List<ChargeLog> query(ChargeLogQueryParam chargeLogQueryParam);

    @Select("select c.charge,date_format(c.created_time,'%Y-%m-%d %H:%i:%s') as created_time" +
            " from charge_log c" +
            " where c.user_id = #{0}")
    @Results(id = "chargeLogPageVo", value = {
            @Result(column = "charge", property = "charge", jdbcType = JdbcType.VARCHAR),
            @Result(column = "created_time", property = "time", jdbcType = JdbcType.VARCHAR)
    })
    List<ChargeLogPageVo> queryByUserId();

}
