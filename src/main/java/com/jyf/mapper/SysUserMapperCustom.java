package com.jyf.mapper;

import com.jyf.domain.SysUser;

import java.util.List;

public interface SysUserMapperCustom{
    List<SysUser> queryUserSimplyInfoById(String id);
}