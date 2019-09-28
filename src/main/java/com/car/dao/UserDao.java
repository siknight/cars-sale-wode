package com.car.dao;

import com.car.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where name=#{username}")
    public User LoginByUsername(@Param("username") String username);

    @Insert("insert into user(name,password) values(#{username},#{password})")
    public Boolean Register(@Param("username") String username,@Param("password") String password);

    @Delete("delete from user where id=#{id}")
    public Boolean deleteById(int id);

    @Update("update user set name=#{username},password=#{password},sex=#{sex} where id=#{id}")
    public Boolean updateById(@Param("username") String username,@Param("password") String password,@Param("sex") String sex,@Param("id") int id);

}
