package com.w1101.gamemarket.service;

import com.w1101.gamemarket.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
public interface IUserService extends IService<User> {

    User selectUserInfo(int userId);


    int updateBalance(User user);

    int updateInfo(User user);

    User login(User user);
}
