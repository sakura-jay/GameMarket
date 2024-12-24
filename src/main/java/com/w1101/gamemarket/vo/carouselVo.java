package com.w1101.gamemarket.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class carouselVo {
    private Integer index;
    List<Game> cards;
}
