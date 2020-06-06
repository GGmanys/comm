package com.ypyay.comm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户信息
 */

@Data
@TableName("yp_member")
@ApiModel(value = "用户信息")
public class Member implements Serializable {
    @TableId
    private Integer id;
    @ApiModelProperty(value = "登录账号")
    private String account;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "性别：0 未知 1 男 2 女")
    private Integer gender;
    @ApiModelProperty(value = "账号余额（消费余额）")
    private BigDecimal money;
    @ApiModelProperty(value = "积分")
    private Integer jifen;
    @ApiModelProperty(value = "取现密码")
    private String payCode;
    @ApiModelProperty(value = "状态：0 禁用 1 启用")
    private Integer status;
    @ApiModelProperty(value = "入驻时间（使用unix时间戳）")
    private Integer createTime;
    @ApiModelProperty(value = "更新时间（使用unix时间戳）")
    private Integer updateTime;
    @ApiModelProperty("支付密码")
    private String payPassword;

}