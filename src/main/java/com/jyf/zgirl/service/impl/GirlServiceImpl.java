package com.jyf.zgirl.service.impl;

import com.jyf.zgirl.dao.GirlDao;
import com.jyf.zgirl.domain.Girl;
import com.jyf.zgirl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    private GirlDao girlDao;
    @Override
    public Integer insert(Girl girl) {
        return girlDao.insert(girl);
    }

    @Override
    public void getAge(Integer id) throws Exception{
        Girl girl = girlDao.get(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new Exception("你还在上小学");
        }else if( age >= 10 && age<16){
            throw new Exception("你还在上初中");
        }
    }

    @Override
    public Girl get(Integer id) {
        return girlDao.get(id);
    }
}
