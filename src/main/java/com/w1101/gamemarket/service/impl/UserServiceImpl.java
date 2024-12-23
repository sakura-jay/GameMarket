package com.w1101.gamemarket.service.impl;

import com.w1101.gamemarket.entity.User;
import com.w1101.gamemarket.mapper.UserMapper;
import com.w1101.gamemarket.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
