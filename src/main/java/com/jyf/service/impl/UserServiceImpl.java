package com.jyf.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyf.domain.SysUser;
import com.jyf.mapper.SysUserMapper;
import com.jyf.mapper.SysUserMapperCustom;
import com.jyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(SysUser sysUser) {
        userMapper.insert(sysUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(SysUser sysUser) {
        userMapper.updateByPrimaryKeySelective(sysUser);
//        userMapper.updateByPrimaryKey(sysUser); 其他字段干空
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserList(SysUser sysUser) {
        return userMapper.select(sysUser);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserListPaged(SysUser sysUser, Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(sysUser.getNickname())){
            criteria.andLike("nickname","%"+sysUser.getNickname()+"%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = userMapper.selectByExample(null);
        return userList;
    }

    @Override
    public SysUser queryUserSimplyInfoById(String id) {
        List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(id);
        if(userList != null && !userList.isEmpty()){
            return (SysUser)userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser sysUser) {
        userMapper.insert(sysUser);

        int a = 1/0;

//        userMapper.updateByPrimaryKeySelective(sysUser);
        sysUser.setIsDelete(1);
        this.update(sysUser);
    }
}
