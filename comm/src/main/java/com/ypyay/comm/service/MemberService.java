package com.ypyay.comm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ypyay.comm.entity.Member;

public interface MemberService extends IService<Member> {

        Member UserInfo(Integer id);
}
