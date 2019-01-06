package com.todo.service.impl;

import com.todo.dao.TodoLoginUserMapper;
import com.todo.dao.TodoUserMapper;
import com.todo.dataobject.TodoLoginUser;
import com.todo.dataobject.TodoUser;
import com.todo.model.LoginUser;
import com.todo.model.Response;
import com.todo.model.User;
import com.todo.service.EmailService;
import com.todo.service.UserService;
import com.todo.util.CheckForm;
import com.todo.util.IDUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.regex.Pattern;




@Component
@Path("user")
public class UserServiceImpl implements UserService {
    @Autowired
    private EmailService emailService;

    @Autowired
    TodoLoginUserMapper todoLoginUserMapper;

    @Autowired
    TodoUserMapper todoUserMapper;

    private String activeCode;

    private TodoUser todoUser = new TodoUser();

    /**
     * 检查在数据库中该邮箱是否注册过
     *
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        return todoLoginUserMapper.selectByPrimaryKey(email) != null;
    }

    /**
     * 密码加密
     *
     * @param password
     * @param slat
     * @return
     */
    public static String m5Password(String password, String slat) {
        String md5Hex = DigestUtils.md5Hex(password + slat).toUpperCase();
        return md5Hex;
    }

    /**
     * 验证两次密码格式和一致性，若一致则将激活码发送至邮箱
     * 同时记录发出的激活码
     * （可在前端实现）
     *
     * @param pwd
     * @param secondPwd
     * @return
     */
    @POST
    @Path("/sendEmail")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail(@QueryParam("email") String email,
                              @QueryParam("pwd") String pwd, @QueryParam("secondPwd") String secondPwd) {
        Response resp = new Response();

        if (!pwd.equals(secondPwd)) {
            resp.setMessage("密码不一致");
            resp.setStatusCode("500");
            return null;
        }
        if (CheckForm.checkPassword(secondPwd)) {
            resp.setMessage("密码格式不正确");
            resp.setStatusCode("500");
            return null;
        }
        if (checkEmail(email)) {
            resp.setMessage("邮箱已被注册");
            resp.setStatusCode("500");
            return null;
        }
        activeCode = IDUtil.getId();
        resp.setMessage("可以申请,验证码为"+activeCode);
        resp.setStatusCode("200");

        emailService.send(email, "验证码", "验证码为：" + activeCode);

        return resp;
    }

    /**
     * 验证发出的激活码和用户输入的激活码是否一致
     * 若一致则完成申请写入数据库
     * 在其他请求中继续完善个人信息
     *
     * @param email
     * @param userActiveCode
     * @param activeCode
     * @param pwd
     * @param secondPwd
     * @return
     */
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public TodoLoginUser register(@QueryParam("email")String email,
                                  @QueryParam("useractivecode") String userActiveCode,
                                  @QueryParam("activecode")String activeCode,
                                  @QueryParam("pwd")String pwd,
                                  @QueryParam("secondPwd")String secondPwd){
        String userId = IDUtil.getId();
        TodoLoginUser todoLoginUser = new TodoLoginUser();
        todoLoginUser.setUserid(userId);
        todoLoginUser.setGmtModified(new Date());
        todoLoginUser.setGmtCreated(new Date());
        todoLoginUser.setEmail("970557317@qq.com");
        todoLoginUser.setRegtime(new Date());

        todoUser.setId(todoLoginUser.getUserid());
        todoUser.setPwd(m5Password(pwd, "lcy"));
        todoUser.setLastpwd(m5Password(secondPwd, "lcy"));
        todoUser.setGmtCreated(new Date());
        todoUser.setGmtModified(new Date());
        todoUser.setPwdlength(String.valueOf(pwd.length()));
        todoUser.setSlat("lcy");
        todoUser.setEncrypt("m5");

        if (userActiveCode.equals(activeCode)) {
            todoUserMapper.insert(todoUser);
            todoLoginUserMapper.insert(todoLoginUser);
            return todoLoginUser;
        }
        return null;
    }

    @Override
    public LoginUser login(String email, String pwd) {
        return null;
    }

    @Override
    public LoginUser register(User user) {
        return null;
    }

    @Override
    public LoginUser update(LoginUser user) {
        return null;
    }

    @Override
    public boolean updatePwd(String userId, String pwd) {
        return false;
    }

    @Override
    public boolean forgetPwd(String userId) {
        return false;
    }

    @Override
    public LoginUser getUser(String userId) {
        return null;
    }
}
