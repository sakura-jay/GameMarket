package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @author qihui
 * @since 2024-12-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("admin")
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("管理员ID")
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    @ApiModelProperty("管理员用户名")
    private String adminName;

    @ApiModelProperty("管理员密码")
    private String adminPwd;

    @ApiModelProperty("管理员邮箱")
    private String adminEmail;

    @ApiModelProperty("管理员加入日期")
    private LocalDateTime adminJoindate;
}
