package com.senzmate.m2m.document;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by john on 1/5/15.
 */
public class AccountDocument {

    @Id
    private String id;
    private String password;
    private String name;

    @CreatedDate
    private DateTime createdTime;
    @LastModifiedDate
    private DateTime modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountDocument{" +
                "id='" + id + '\'' +
                ", password='" + "******" + '\'' +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
