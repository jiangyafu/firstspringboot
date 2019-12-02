package com.jyf.zgirl.dao;

import com.jyf.zgirl.domain.Girl;



public interface GirlDao {
    Integer insert(Girl girl);

    Girl get(Integer id);
}
