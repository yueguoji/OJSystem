package com.yue.yojbackenduserservice.controller.inner;

import com.yue.yojBackendModel.model.entity.User;
import com.yue.yojbackendserviceclient.service.UserFeignClient;
import com.yue.yojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Yuuue
 * creat by 2023-10-05
 */
@RestController
@RequestMapping("/inner")
public class InnerUserController implements UserFeignClient {

    @Resource
    private UserService userService;
    /**
     * 获取User
     *
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getUserById(@RequestParam("userId") Long userId) {
        return userService.getById(userId);
    }

    /**
     * 获取user集合
     *
     * @param userIdSet
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> userlistById(@RequestParam("userId") Collection<Long> userIdSet) {
        return userService.listByIds(userIdSet);
    }
}
