package com.w1101.gamemarket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.w1101.gamemarket.vo.noticevo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
public interface IAnnouncementService extends IService<Announcement> {
    Page<Announcement> selectlist(noticevo vo);
}
