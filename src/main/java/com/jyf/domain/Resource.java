package com.jyf.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: yafu jiang
 * @Date: 2019/11/14 0014 14:56
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "com.jyf.opensource")
@PropertySource(value="classpath:resource.properties")
public class Resource {

    private String name;
    private String website;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}


