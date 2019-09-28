package com.car.service;

import com.car.bean.User;
import com.car.dao.UserDao;
import com.car.util.Result;
import com.car.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    /**
     * 用户登陆
     * @param username 用户名
     * @param userpass 密码
     * @return
     */
    public Result login(String username,String userpass){
            Result result = new Result();
            System.out.println("username="+username+"userpass="+userpass);
            //用户名为空
            if (StringUtils.isEmpty(username)){
                result.setCode(ResultMsg.USERNAME_NULL_CODE);
                result.setMsg(ResultMsg.USERNAME_NULL_MSG);
                result.setData(null);
                return  result;
            }
            //密码为空
            if (StringUtils.isEmpty(userpass)){
                result.setCode(ResultMsg.PASSWORD_NULL_CODE);
                result.setMsg(ResultMsg.PASSWORD_NULL_MSG);
                result.setData(null);
                return  result;
            }
            //数据库查询
            User user = dao.LoginByUsername(username);
            System.out.println("user...username="+user.getName()+",userpass="+user.getPassword());
            //判断是否存在改用户
            if(user==null){
                result.setCode(ResultMsg.USER_NOT_EXIT_CODE);
                result.setMsg(ResultMsg.USER_NOT_EXIT_MSG);
                result.setData(null);
                return  result;
            }
            //判断密码是否正确
            if (!userpass.equals(user.getPassword())){
                result.setCode(ResultMsg.PASSWORD_IS_ERROR_CODE);
                result.setMsg(ResultMsg.PASSWORD_IS_ERROR_MSG);
                result.setData(null);
                return  result;
            }
            //用户登陆成功封装result
            result.setCode(ResultMsg.OK);
            result.setMsg(ResultMsg.LOGIN_SUCCESS);
            user.setPassword(null);
            result.setData(user);

            return result;

    }
}
