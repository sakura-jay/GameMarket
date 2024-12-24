package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.User;
import com.w1101.gamemarket.service.IUserService;
import com.w1101.gamemarket.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping("login")
    public  Result login(User user){

        User loginUser = userService.login(user);
        if (loginUser == null){
            return Result.fail();
        }
        loginUser.setUserPassword(null);
        return Result.success(loginUser);
    }

    @GetMapping("userInfo")
    public Result getUserInfo(int userId){

        return Result.success(userService.selectUserInfo(userId));
    }

    @PutMapping("updateBalance")
    public Result updateBalance(User user){
       int result = userService.updateBalance(user);
       if (result == 0) return Result.fail();
       return Result.success();
    }

    @PutMapping("updateInfo")
    public Result updateInfo(User user){

        int result = userService.updateInfo(user);
        if (result == 0) return Result.fail();
        return Result.success();
    }

}
