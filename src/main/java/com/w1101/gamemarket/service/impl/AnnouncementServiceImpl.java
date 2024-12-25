package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Announcement;
import com.w1101.gamemarket.mapper.AnnouncementMapper;
import com.w1101.gamemarket.service.IAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.gamemarket.vo.noticevo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {
    @Resource
    private AnnouncementMapper mapper;
    @Override
    public Page<Announcement> selectlist(noticevo vo ) {
        Page<Announcement> page = new Page<>(vo.getPageNum(),vo.getPageSize());
        QueryWrapper<Announcement> wrapper = new QueryWrapper<>();
        return  mapper.selectPage(page,wrapper);
    }
}
