package com.jyf.zgirl.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

public class Girl {
    private Integer Id;
    @Min(value = 18,message = "未成年少女禁止入内")
    //    @NotNull
//    @Max()
//    @Length()
    private Integer Age;
    @NotBlank(message = "这个字段必传")
    private String Name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "Id=" + Id +
                ", Age=" + Age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
