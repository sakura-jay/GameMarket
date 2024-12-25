package com.w1101.gamemarket.vo;

import lombok.Data;

@Data
public class noticevo {
   private Integer pageNum;
    private Integer  pageSize;
  private String announcementTitle;
    private String    content;
    private String publishDate;
    private String  announcementId;
    private Integer total;
}
