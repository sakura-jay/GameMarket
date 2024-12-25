package com.w1101.gamemarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Announcement;
import com.w1101.gamemarket.service.IAnnouncementService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.noticevo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Resource
    private IAnnouncementService announcementService;
    @GetMapping("/list")
    public Result list(noticevo vo) {


        Page<Announcement> list= announcementService.selectlist(vo);
        return Result.success(list);
    }
}
