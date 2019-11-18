package com.jyf.service;

import com.jyf.domain.SysUser;

import java.util.List;

public interface UserService {

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    void delete(String userId);

    SysUser queryUserById(String userId);

    List<SysUser> queryUserList(SysUser sysUser);

    List<SysUser> queryUserListPaged(SysUser sysUser,Integer page,Integer pageSize);


    SysUser queryUserSimplyInfoById(String id);

}
