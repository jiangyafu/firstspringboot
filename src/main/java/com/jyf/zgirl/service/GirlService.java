package com.jyf.zgirl.service;

import com.jyf.zgirl.domain.Girl;

public interface GirlService {
    Integer insert(Girl girl);

    void getAge(Integer id) throws Exception;

    Girl get(Integer id);
}
