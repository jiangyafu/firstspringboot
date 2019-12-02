package com.jyf.zgirl.utils;

import com.jyf.zgirl.domain.Result;

/**
 * @Author: yafu jiang
 * @Description:
 * @Date:Create：in 2019/12/2 23:10
 * @Modified By：
 */
public class ResultUtil {

    public static Result success(){
        return success(null);
    }
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMeg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String meg){
        Result result = new Result();
        result.setCode(code);
        result.setMeg(meg);
        return result;
    }
}
