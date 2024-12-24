package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Announcement对象", description = "")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("公告ID")
    @TableId(value = "announcement_id", type = IdType.AUTO)
    private Integer announcementId;

    @ApiModelProperty("公告标题")
    private String announcementTitle;

    @ApiModelProperty("公告内容")
    private String content;

    @ApiModelProperty("发布日期")
    private LocalDateTime publishDate;
}
