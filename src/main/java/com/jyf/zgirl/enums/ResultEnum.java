package com.jyf.zgirl.enums;

import com.jyf.zgirl.exection.GirlException;

/**
 * @Author: yafu jiang
 * @Description:
 * @Date:Create：in 2019/12/2 23:45
 * @Modified By：
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能还在上初中"),
    ;

    private Integer code;
    private String meg;
    ResultEnum(Integer code,String msg){
        this.code = code;
        this.meg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMeg() {
        return meg;
    }

    public static void main(String[] args) {
        throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
    }
}
