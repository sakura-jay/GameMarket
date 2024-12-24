package com.w1101.gamemarket.vo;

import com.w1101.gamemarket.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class pageVo {
    private Integer userId;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private List<Game> list;
}
