package com.yue.yojbackendserviceclient.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yue.yojBackendCommon.common.ErrorCode;
import com.yue.yojBackendCommon.exception.BusinessException;
import com.yue.yojBackendModel.model.entity.User;
import com.yue.yojBackendModel.model.enums.UserRoleEnum;
import com.yue.yojBackendModel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.yue.yojBackendCommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@FeignClient(name = "yoj-backend-user-service",path = "/api/user/inner")  //这里的name对应配置文件中的spring.application.name
public interface UserFeignClient {

    /**
     * 获取User
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    User getUserById(@RequestParam("userId") Long userId);

    /**
     * 获取user集合
     * @param userIdSet
     * @return
     */
    @GetMapping("/get/ids")
    List<User> userlistById(@RequestParam("userIdSet") Collection<Long> userIdSet);


    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    default User getLoginUser(HttpServletRequest request){
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    }

/*
对于以下几个 ，不利于远程调用传递参数、或者实现起来非常简单（工具类），可以直接用默认方法，无需远程调用，节约性能。
 */


    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    default boolean isAdmin(HttpServletRequest request){
        // 仅管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        return isAdmin(user);
    }



    default boolean isAdmin(User user) {
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }


    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    default UserVO getUserVO(User user){
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }



}
