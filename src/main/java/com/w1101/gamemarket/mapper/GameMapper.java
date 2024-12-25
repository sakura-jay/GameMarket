package com.w1101.gamemarket.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w1101.gamemarket.vo.pageVo;
import com.w1101.gamemarket.vo.typevo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
public interface GameMapper extends BaseMapper<Game> {
    Page<Game> selectByPage(@Param("page") Page<Game> page, @Param("userId") Integer userId);

    int selectPageTotal(pageVo vo);


    @Select("SELECT * FROM game " +
            "LEFT JOIN gametype ON game.game_id = gametype.game_id " +
            "WHERE gametype.type = #{selectedTags}")
    Page<Game> selectTypeList(@Param("page") Page<Game> page,@Param("selectedTags") String selectedTags);

    @Select({
            "<script>",
            "SELECT DISTINCT game.*", // 使用 DISTINCT 确保每个游戏只出现一次
            "FROM game",
            "LEFT JOIN gametype ON game.game_id = gametype.game_id",
            "LEFT JOIN factory ON game.factory_id = factory.factory_id",
            "WHERE 1 = 1",  // 确保每个条件都有 AND 前缀
            "<if test='title != null and title != \"\"'>",
            "  AND game.game_title LIKE CONCAT('%', #{title}, '%')", // 模糊匹配 title
            "</if>",
            // 处理 type 参数为空字符串或 null 的情况
            "<if test='type != null and type != \"\"'>",
            "  AND gametype.type = #{type}",
            "</if>",

            // 处理 platform 参数为空字符串或 null 的情况
            "<if test='platform != null and platform != \"\"'>",
            "  AND game.platform = #{platform}",
            "</if>",

            // 处理 order 参数为空字符串或 null 的情况
            "<if test='order != null and order != \"\"'>",
            "  ORDER BY ${order}", // 使用 #{order} 可能会引起 SQL 注入，推荐使用 ${order}，但要确保 order 是合法字段
            "</if>",

            "</script>"
    })
    Page<Game> selectPage(@Param("page") Page<Game> page,@Param("type") String type, @Param("platform") String platform,@Param("order") String order,@Param("title") String title);

}
