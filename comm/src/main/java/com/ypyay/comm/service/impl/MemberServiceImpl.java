package com.ypyay.comm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypyay.comm.entity.Member;
import com.ypyay.comm.mapper.MemberMapper;
import com.ypyay.comm.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public Member UserInfo(Integer id) {
        return  baseMapper.getUserInfo(id);
    }
}
