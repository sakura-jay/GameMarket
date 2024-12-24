package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.w1101.gamemarket.entity.User;
import com.w1101.gamemarket.mapper.LibraryMapper;
import com.w1101.gamemarket.mapper.UserMapper;
import com.w1101.gamemarket.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
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

    @Resource
    private UserMapper mapper;
    private LibraryMapper libraryMapper;
    @Override
    public User selectUserInfo(int userId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);

        return mapper.selectOne(wrapper);
    }

    @Override
    public int updateBalance(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        User queryUser = mapper.selectOne(queryWrapper);

        wrapper.eq("user_id",user.getUserId());
        wrapper.set("user_balance",user.getUserBalance().add(queryUser.getUserBalance()));

        return mapper.update(wrapper);
    }

    @Override
    public int updateInfo(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();

        wrapper.eq("user_id",user.getUserId());
        wrapper.set("user_nickname",user.getUserNickname());
        wrapper.set("user_email",user.getUserEmail());

        return mapper.update(wrapper);
    }


}
