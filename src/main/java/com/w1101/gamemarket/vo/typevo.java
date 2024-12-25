package com.w1101.gamemarket.vo;

import java.util.List;

import lombok.Data;

@Data
public class typevo <T>{
   private Integer pageNum;
    private Integer pageSize;
      private String selectedTags;
    private List<T> list;
    private Integer pageStart;
    private Integer total;
}
