package com.jyf.zgirl.domain;

/**
 * @Author: yafu jiang
 * @Description: 返回最外层对象
 * @Date:Create：in 2019/12/2 23:00
 * @Modified By：
 */
public class Result<T> {

    private Integer code;//错误码
    private String meg;//错误信息
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMeg() {
        return meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
