package com.w1101.gamemarket.vo;


import lombok.Data;

import java.util.List;

@Data
public class gamevo<T> {
    private Integer gameId;
    private Integer pageNum;
    private Integer pageSize;
    private String  title;
    private String  avatar;
    private String selectedTags ; // 初始为空或选择的标签
   private String selectedpratforms;// 初始为空或选择的平台
    private Integer pageStart;
    private List<T> list;
    private String   order;
    private Integer total;
}
