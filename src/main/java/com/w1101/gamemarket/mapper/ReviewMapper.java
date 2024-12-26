package com.w1101.gamemarket.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w1101.gamemarket.vo.reviewVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
public interface ReviewMapper extends BaseMapper<Review> {
    Page<reviewVo> selectByPage(@Param("page") Page<reviewVo> page,@Param("gameId") Integer gameId);
}
