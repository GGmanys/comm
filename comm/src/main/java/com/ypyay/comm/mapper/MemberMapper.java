package com.ypyay.comm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ypyay.comm.entity.Member;
import org.apache.ibatis.annotations.Param;

/**
 * 用户个人信息表
 */
//@CacheNamespace(implementation = MybatisRedisCacheUtils.class, eviction = MybatisRedisCacheUtils.class)
public interface MemberMapper extends BaseMapper<Member> {

    Member  getUserInfo(@Param("id") int user_id);
}
