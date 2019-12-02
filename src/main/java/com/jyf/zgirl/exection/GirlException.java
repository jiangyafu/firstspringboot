package com.jyf.zgirl.exection;

import com.jyf.zgirl.enums.ResultEnum;

/**
 * @Author: yafu jiang
 * @Description:
 * @Date:Create：in 2019/12/2 23:36
 * @Modified By：
 */
public class GirlException extends RuntimeException {

    private Integer code;

    /*public GirlException(Integer code,String message){
        super(message);
        this.code=code;
    }*/
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMeg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
