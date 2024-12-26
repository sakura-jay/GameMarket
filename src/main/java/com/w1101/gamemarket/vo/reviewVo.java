package com.w1101.gamemarket.vo;

import lombok.Data;

@Data
public class reviewVo {
    private Integer gameId;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private String userNickname;
    private String remark;
    private String reviewDate;
}
