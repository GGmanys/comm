package com.ypyay.comm.controller;

import com.ypyay.comm.common.ResultData;
import com.ypyay.comm.entity.Member;
import com.ypyay.comm.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/shopAdditional")
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "query", paramType = "string", required = true),
    })
    public ResultData UserInfo(Integer id){
        Member member = memberService.UserInfo(id);
        log.info("member:{}",member);
        return ResultData.success(member);
    }
}
