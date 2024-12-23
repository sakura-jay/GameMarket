package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String userNickname;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("邮箱")
    private String userEmail;

    @ApiModelProperty("头像")
    private String userAvatar;

    @ApiModelProperty("余额")
    private BigDecimal userBalance;

    @ApiModelProperty("加入日期")
    private LocalDateTime userJoindate;

    @ApiModelProperty("状态")
    private Integer userStatus;
}
